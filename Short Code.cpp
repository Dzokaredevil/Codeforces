#include<stdlib.h>
#include<stdio.h>
#include<math.h>

#define N 100001

#include<set>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;

#define mp make_pair

string s;bool x[N];
set<pair<int,int> >d;
int n, t[N][26], r[N], dep[N], cnt, ans;

void insert(string S){
	int _ = 0, n = S.size();
	for(int i = 0; i < n; i++){
		if(!t[_][S[i] - 'a'])
			t[_][S[i] - 'a'] = ++cnt;
		r[t[_][S[i] - 'a']] = _, _ = t[_][S[i]-'a'], dep[_] = i+1;
	}
	d.insert(mp(n,_)),x[_] = true, ans += n;
}
void refind(int cur){
	int nxt = -1, res = 0, c = 0;
	while(r[cur]){
		cur = r[cur], c++;
		if(!x[cur]){
			ans -= c, x[cur] = true, d.insert(mp(dep[cur],cur));
			return;
		}
	}
}
int main()
{ 
	scanf("%d", &n);
	for(int i = 1; i <= n; i++){
		cin >> s;
		insert(s);
	}
	while(d.size())refind((*d.rbegin()).second), d.erase(*d.rbegin());
	return printf("%d\n", ans),0;
}
