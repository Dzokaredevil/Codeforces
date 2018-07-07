#include <bits/stdc++.h>

using namespace std;

const int maxn = 1000100;

long long ps[maxn]; 

long long max(long long x, long long y){return (x > y ? x : y);}
long long min(long long x, long long y){return (x < y ? x : y);}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    long long n;
    string s;
    cin >> s;
    n = s.size();
    for(int i = 1; i < n; i++)
    {
        if(s[i] == s[i - 1]){ps[i] = ps[i - 1] + 1;}
        else{ps[i] = ps[i - 1];}
    }
    long long m;
    cin >> m;
    for(int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        a--; b--;
        cout << ps[b] - ps[a] << endl;
    }
    return 0;
}
