#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<int,int> ii;
typedef vector<int>   vi;
typedef vector< ii >  vii;

#define all(x)  (x).begin(), (x).end()
#define fi  first
#define se  second
#define pb  push_back


int const MOD   =  1000000000 + 7 ;
int const MAXN  =  105050         ;
int const MAXSH =  1 << 19        ;
int const SH = 18;

ll gcd(ll x, ll y){ return  y == 0 ? x : gcd( y, x % y ) ; }
ll lcm(ll x, ll y){ return ( x == 0 || y == 0) ? ( x + y ) : ( x / gcd( x, y ) ) * y ; } 

struct node;


node* alloc_node();

struct node
{
    int mx;
    node *bit[2];
    node(){ bit[0] = bit[1] = 0; mx= MAXN ;}
    void add(int x)
    {
        node* c = this;
        c->mx = min(c->mx, x);
        for(int i  = SH; i >=0 ; --i)
        {
            int b = (x >> i) & 1;
            if ( ! c->bit[b]) c->bit[b] = alloc_node();
            c = c->bit[b];
            c->mx = min(c->mx, x);
        }
    }
}* nodes[ MAXN ];

static node  mempool[ MAXN * (SH + 1) * 8 ];
node* alloc_node()
{ 
    
    static int id =  0;
    static int sz_pool = sizeof(mempool) / sizeof(mempool[0]);
    
    if (id >= sz_pool) return new node;
    
    return mempool + (id++);
}

int add_n(int n, int x)
{
    if ( ! nodes[n] ) nodes[n] = new node;
    nodes[n]->add(x);
}

int add(int x)
{
    for(int i = 1; i * i <= x; ++i)
    {
        if ( x % i == 0 )
        {
            add_n(i, x);
            add_n(x/i, x);
        }
    }
}

int query(int x, int k, int s)
{
    if (x % k  != 0 || s - x <= 0 ||  ! nodes[k ] || nodes[k]->mx + x > s )
        return -1;
    
    node* c = nodes[k];
    int val = 0;
    for(int i = SH; i >= 0; --i)
    {
        int bit = (x >> i) & 1;
        if (c->bit[bit^1] != nullptr && c->bit[bit^1]->mx + x <= s )
        {
            c = c->bit[bit^1];
            val += (bit^1) << i;
        } else {
            c = c->bit[bit];
            val += bit << i;
        }
    }
    return val;
}


int solve()
{
    int q;scanf("%d", &q);
    
    //mempool = new node[ q * ( SH + 2 ) ] ;
    
    while(q--)
    {
        int t;scanf("%d", &t);
        if (t == 1){
            int x;scanf("%d", &x); add(x);
        } else {
            int x, k, s;
            scanf("%d%d%d", &x, &k, &s);
            printf("%d\n", query(x, k, s) ) ;
        }
    }
    
    
    return 0; 
}
  
int main()
{
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif     
    
    ::std::ios::sync_with_stdio(false);  
    ::std::cin.tie(0); 
    ::std::cout.tie(0);
 
    
    solve();
    
    return 0;
}