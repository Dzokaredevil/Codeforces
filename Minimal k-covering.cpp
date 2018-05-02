#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

const ll oo = 1e18;
const int N = 20005, E = 300006;

vector<int> g[N];

int ne;

struct Edge{
    int from, to;
    ll cap;
} edge[E];

int lvl[N], vis[N], pass, source, target, px[N];

ll run(int s, ll minE){
    if(s == target){
		return minE;
	}

    ll ans = 0;

    for(; px[s] < (int)g[s].size(); px[s]++){
        int e = g[s][ px[s] ];
        auto &v = edge[e], &rev = edge[e^1];
        if(lvl[v.to] != lvl[s]+1 || v.cap <= 0) continue;
        ll tmp = run(v.to, min(minE, v.cap));
        v.cap -= tmp, rev.cap += tmp;
        ans += tmp, minE -= tmp;
        if(minE == 0) break;
    }
    return ans;
}

int bfs(){
    queue<int> q;
    q.push(source);
    lvl[source] = 1;
    vis[source] = ++pass;

    while(!q.empty()){
        int u = q.front(); q.pop();
        px[u] = 0;

        for(int e : g[u]){
            auto v = edge[e];
            if(v.cap <= 0 || vis[v.to] == pass) continue;
            vis[v.to] = pass;
            lvl[v.to] = lvl[u]+1;
            q.push(v.to);
        }
    }
    return vis[target] == pass;
}

ll flow(){
    ll ans = 0;
    while(bfs()) ans += run(source, oo);
    return ans;
}

void addEdge(int u, int v, ll c){
    edge[ne] = {u, v, c};
    g[u].push_back(ne++);
    edge[ne] = {v, u, 0};
    g[v].push_back(ne++);
}
 
int in[N];

int main(){
	int n1, n2, m;

	source = N-1, target = N-2;

	scanf("%d %d %d", &n1, &n2, &m);

	for(int i = 0; i < m; i++){
		int a, b;
		scanf("%d %d", &a, &b);
		a--, b--;
		in[a]++, in[n1+b]++;
		b += n1;
		addEdge(a, b, 1);
	}
	
	int k = m;
	for(int i = 0; i < n1; i++) k = min(k, in[i]);
	for(int i = 0; i < n2; i++)	k = min(k, in[i+n1]);

	int em = ne;

	for(int i = 0; i < n1; i++)
		addEdge(source, i, in[i]-k-1);

	int e1 = ne;
	for(int i = 0; i < n2; i++)
		addEdge(n1+i, target, in[n1+i]-k-1);

	int e2 = ne;

	vector<vector<int> > ans;

	for(; k >= 0; k--){
		for(int i = em; i < e2; i += 2) edge[i].cap++;
		
		flow();
		vector<int> tmp;

		for(int i = 0; i < em; i += 2) if(edge[i].cap)
			tmp.push_back(i/2 + 1);
		ans.emplace_back(move(tmp));
	}

	for(int i = (int)ans.size() - 1; i >= 0; i--){
		printf("%d", (int)ans[i].size());
		for(int x : ans[i]) printf(" %d", x);
		printf("\n");
	}
}
