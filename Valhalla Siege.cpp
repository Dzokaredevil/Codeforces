#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main()
{
	ll n, q;
	cin >> n >> q;
	ll a[n];
	cin >> a[0];
	for(ll i = 1; i < n; i++){
		cin >> a[i], a[i] += a[i-1];
	}
	ll cur = 0;
	while(q--){
		ll k;
		cin >> k;
		cur += k;
		ll x = upper_bound(a, a+n, cur) - a;
		if(x >= n){
			x = 0;
			cur = 0;
		}
		cout << n-x << endl;
	}
	return 0;
}