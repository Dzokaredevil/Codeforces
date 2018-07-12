#include <bits/stdc++.h>

using namespace std;

typedef int32_t i32;
typedef uint32_t u32; 
typedef int64_t i64;
typedef uint64_t u64;
typedef float f32;
typedef double f64;
typedef __float80 f80;
typedef __float128 f128;

typedef pair<u32,u32> para;

namespace _hidden {
	template<char... args> struct str_m {static const char data[sizeof...(args)];};
	template<char... args> constexpr const char str_m<args...>::data[sizeof...(args)] = { args... };
	
	template <bool cont,size_t pos,typename s,char... chrs>
	struct reverse_m {
		typedef typename reverse_m<s::data[pos],pos+1,s,s::data[pos],chrs...>::result result;
	};
	template <size_t pos,typename s,char c,char... chrs>
	struct reverse_m<false,pos,s,c,chrs...> {
		typedef str_m<chrs...,0> result;
	};
	
	template <bool init,size_t num,size_t pos,typename s1,typename s2,char... chrs>
	struct concat_m {
		typedef typename concat_m<!s2::data[pos+1],num-!s2::data[pos+1],pos+1,s1,s2,chrs...,s2::data[pos]>::result result;
	};
	template <size_t num,size_t pos,typename s2,typename s1,char... chrs>
	struct concat_m<true,num,pos,s2,s1,chrs...> {
		typedef typename concat_m<!s2::data[0],num-!s2::data[0],0,s1,s2,chrs...>::result result;
	};
	template <size_t pos,typename s1,typename s2,char... chrs>
	struct concat_m<true,0,pos,s1,s2,chrs...> {
		typedef str_m<chrs...,0> result;
	};
	
	template<int N>
	struct int2str{
		typedef typename reverse_m<true,0,str_m<(N>>0)&0xff,(N>>8)&0xff,(N>>16)&0xff,(N>>24)&0xff,0> >::result result;
	};

	template<typename T> struct fmt;

	template<int F, typename T, typename... args> struct fmts {typedef typename concat_m< true,2,0,typename fmts<F,T>::result,typename fmts<F,args...>::result >::result result;};
	template<int F,typename T> struct fmts<F,T> {typedef typename concat_m< true,2,0,fmt<T>,typename int2str<F>::result >::result result;};
	
	template<typename T> struct fmt<T*> {constexpr static const char* data="%p";};
	template<> struct fmt<i32> {constexpr static const char* data="%" PRIi32;};
	template<> struct fmt<u32> {constexpr static const char* data="%" PRIu32;};
	template<> struct fmt<i64> {constexpr static const char* data="%" PRIi64;};
	template<> struct fmt<u64> {constexpr static const char* data="%" PRIu64;};
	template<> struct fmt<f32> {constexpr static const char* data="%f";};
	template<> struct fmt<f64> {constexpr static const char* data="%lf";};
	template<> struct fmt<f80> {constexpr static const char* data="%Lf";};
	template<> struct fmt<f128> {constexpr static const char* data="%Qf";};
	template<> struct fmt<char> {constexpr static const char* data="%c";};
	
	template<> struct fmt<char*> {constexpr static const char* data="%s";};
	template<> struct fmt<const char*> {constexpr static const char* data="%s";};
	template<size_t N> struct fmt<char[N]> {constexpr static const char* data="%s";};
	
	template <typename A,typename B>
	struct link {
		A data;
		B garbage;
	};
	template <>
	struct link<const char**,const char*>{
		const char** garbage;
		const char* data;
	};
}

#define forn(i,n) for(auto i=(n)-(n);i<(n);++i)
#define forab(i,a,b) for(auto i=(a)+(b)-(b);i<(b);++i)
#define fornd(i,n) for(auto i=(n);i--;)

template<int F=0,typename... Args> constexpr static const inline int pr(const Args... args) {return printf(_hidden::fmts< F,Args... >::result::data,args...);}
template<typename... Args> constexpr static const inline int sc(Args&&... args) {return scanf(_hidden::fmts< 0,decltype(args+0)... >::result::data,_hidden::link<decltype(&args),decltype(args+0)>({&args,args}).data...);}

#define scn(a,n) forn(_read_index,(n)){sc((a)[_read_index]);}
#define scna(a,n,type) size_t (n); sc((n)); type* (a)=new type[(n)]; scn((a),(n));
#define scnn(a,n,type) type* (a)=new type[(n)]; scn((a),(n));

#define prn(a,n) forn(_write_index,(n)){pr<' '>((a)[_write_index]);}

#ifdef noacm
#define dbug(...) pr("\nDBug: ",__VA_ARGS__,'\n')
#define dbugn(a,n) {pr("\nDbug: # ");prn(a,n);pr("#\n");}
#else
#define dbug(...)
#define dbugn(...)
#endif

template <typename T>
int cmp_num(const void* a,const void* b){
	return (*(T)a>*(T)b)-(*(T)a<*(T)b);
}

#define sqsort(a,n) qsort(a,n,sizeof(*a),cmp_num<decltype(a+0)>)
#define tqsort(a,n,type) qsort(a,n,sizeof(*a),cmp_num<type*>)
#define fqsort(a,n,func) qsort(a,n,sizeof(*a),func);

#define sbsearch(key,a,n) (decltype(a+0))bsearch(&key,a,n,sizeof(*a),cmp_num<decltype(a+0)>)
#define tbsearch(key,a,n,type) (decltype(a+0))bsearch(&key,a,n,sizeof(*a),cmp_num<type*>)
#define fbsearch(key,a,n,func) (decltype(a+0))bsearch(&key,a,n,sizeof(*a),func)

#define mt make_tuple


int main(){
	#ifdef noacm
	freopen("input.txt","r",stdin);
	//freopen("output.txt","w",stdout);
	#endif
	
	scna(a,n,u32);
	sqsort(a,n);

	if(a[0]==a[n-1]){
		pr<' '>(0,((u64)n)*(n-1)/2);
	}else{
		u64 l=1,r=1;
		while(a[l]==a[0]){++l;}
		while(a[n-r-1]==a[n-1]){++r;}
		pr<' '>(a[n-1]-a[0],l*r);
	}
	
	#ifdef noacm
	fclose(stdin);
	fflush(stdout);
	//fclose(stdout);
	for(;;);
	#endif
}
