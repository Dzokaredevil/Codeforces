#include <algorithm>
#include <cstdio>

struct A{
	int l,r,i; 
}a[300005];

bool cmp(A x,A y){return x.l<y.l || (x.l==y.l&&x.r>y.r);}

int main(){
	int n;
	scanf("%d",&n);
	for (int i=1;i<=n;i++) scanf("%d%d",&a[i].l,&a[i].r),a[i].i=i;
	std::sort(a+1,a+n+1,cmp);
	for (int i=2;i<=n;i++){
		if (a[i].r<=a[i-1].r){
			printf("%d %d",a[i].i,a[i-1].i);
			return 0;
		}
	}
	puts("-1 -1");
}