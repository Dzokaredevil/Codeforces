#include<bits/stdc++.h> 
using namespace std;

typedef pair<int, int> P;
typedef long long ll;
const int N = 2e5 + 5;
const ll MOD = 1e9 + 9;
 
vector<int> son[N];

int a[N], f[N], tot;
bool vis[N];

bool dfs(int u, int fa){
	int s = !vis[fa];
	for (int v : son[u]) if (v != fa && !vis[v]){
		s += dfs(v, u);
	}
	s %= 2;
	if (!s) a[tot++] = u, vis[u] = 1;
	return s % 2;
}

int main()
{
	int n; scanf("%d", &n);
	for (int i = 1; i <= n; i++){
		int x; scanf("%d", &x);
		if (x){
			son[i].push_back(x);
			son[x].push_back(i); 
		} 
	}
	vis[0] = 1;
	for (int i = 1; i <= n; i++)
		if (!vis[i]){
			if (dfs(i, 0)) return 0 * puts("NO");
		}
	printf("YES\n"); 
	for (int i = 0; i < n; i++) printf("%d\n", a[i]);
	return 0;
}
