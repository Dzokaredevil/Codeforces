#include<iostream>
#include<string>
#include<cmath>
#include<algorithm>
#include<vector>
#include<set>
#include<time.h>

using namespace std;

typedef long long ll;

int main()
{
	ll a, b, mini = 100000, c[80] = { 0 };
	cin >> a >> b;
	for (int i = 0; i < b; i++)
		cin >> c[i];
	sort(c, c + b);
	for (int i = 0; i < b - a + 1; i++)
		mini = min(mini, c[a - 1 + i] - c[i]); 
	cout << mini;
	return 0;
}
