#include <iostream>
#include <queue>
#define mp make_pair
#define ii pair<int,int>

using namespace std;

int n,m,visited[30000],BFS(int);

int main()
{
    cin>>n>>m;
    cout<<BFS(n);
}
int BFS(int node)
{
    queue<ii> q;
    q.push(mp(node,0));
    while(!q.empty())
    {
        ii curr=q.front();
        visited[curr.first]=true;
        q.pop();
        if(curr.first-1 == m || curr.first*2==m)
            return curr.second+1;
        if(curr.first>1 && !visited[curr.first-1])
            q.push(mp(curr.first-1,curr.second+1));
        if(curr.first && curr.first*2<30000 && !visited[curr.first*2])
            q.push(mp(curr.first*2,curr.second+1));
    }
}