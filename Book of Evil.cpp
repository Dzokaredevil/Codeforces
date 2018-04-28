#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int INF = 0x3f3f3f3f;
const int MAXN = 110000;
int dp[MAXN][2], son[MAXN];
int n, m, d, ans;

struct Edge{
	int u, v, nxt;
}e[MAXN << 1]; int e_cnt;
int head[MAXN];

void Add(int u, int v){
	int id = ++ e_cnt;
	e[id].u = u; e[id].v = v;
	e[id].nxt = head[u]; head[u] = id;
}

void Update(int &fir, int &sec, int &son, int thr, int id){
	if(thr > sec) swap(sec, thr); if(sec > fir) swap(fir, sec), son = id;
}	

void DFS1(int u, int fa){
	for(int id = head[u]; ~id; id = e[id].nxt){
		int v = e[id].v; if(v == fa) continue;
		DFS1(v, u); Update(dp[u][0], dp[u][1], son[u], dp[v][0] + 1, v);
	} 
}

void DFS2(int u,int fa){
	if(dp[u][0] <= d) ans ++;
	for(int id = head[u]; ~id; id = e[id].nxt){
		int v = e[id].v; if(v == fa) continue;
		if(son[u] == v) Update(dp[v][0], dp[v][1], son[v], dp[u][1] + 1, u);
		else Update(dp[v][0], dp[v][1], son[v], dp[u][0] + 1, u);
		DFS2(v, u);
	}
}

int main(){
	memset(head, -1, sizeof(head));
	memset(dp, -INF, sizeof(dp));
	scanf("%d%d%d", &n, &m, &d);
	for(int i = 1; i <= m; ++ i){ 
		int x; scanf("%d", &x);
		dp[x][0] = 0; son[x] = x;
	}
	for(int i = 1; i < n; ++ i){
		int u, v; scanf("%d%d", &u, &v);
		Add(u, v); Add(v, u);
	}
	DFS1(1, 0); DFS2(1, 0);
	printf("%d", ans);
	return 0;
}
