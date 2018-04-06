#include <bits/stdc++.h>

using namespace std ;

#define ll long long int
#define loop(i, a, b) for(i=a; i<b; i++)

const int maxn = 1e5 + 10;
const int mod = 1e9 + 7;

ll power(ll x, ll y){
	ll t = 1;
	while(y > 0){
		if(y % 2) y -= 1, t = t*x%mod;
		else y /= 2, x = x*x%mod;
	}
	return t;
}

int main(){
    ll n, i, j = 0, k = 101, l, r;
    cin >> n;
    ll a[n];
    loop(i, 0, n){
		cin >> a[i];
		if(a[i] <= k){
			k = a[i];
			l = i;
		}
		if(a[i] > j){
			j = a[i];
			r = i;
		}
    }
    if(l < r){
        cout << r+n-l-2;
    } else {
        cout << r+n-1-l;
    }
	return 0;
}