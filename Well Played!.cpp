#include <bits/stdc++.h>

using namespace std;

#define l long long
#define f first
#define s second
#define j(a,b) for(i = a; i < b; ++i)

pair<l, pair<l, l> > p[300001];

int main()
{
    l n, a, b, i, h, d, x(0), r(0), t;
    cin >> n >> a >> b;
    b = min(b, n);
    j(0, n){
        cin >> h >> d;
        p[i].f = max(0ll, h - d);
        p[i].s.f = h;
        x += (p[i].s.s = d);
    }
    if (b){
        sort(p, p + n, greater<pair<l, pair<l, l> > >());
        t = 0;
        j(0, b) t += p[i].f;
        j(0, b) r = max(r, t - p[i].f + (p[i].s.f << a) - p[i].s.s);
        j(b, n) r = max(r, t - p[b - 1].f + (p[i].s.f << a) - p[i].s.s);
    }
    cout << r + x;
    return 0;
} 
