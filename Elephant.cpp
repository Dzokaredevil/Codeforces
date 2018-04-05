#include <bits/stdc++.h>

using namespace std;

int main(){
	int n;
	cin >> n;
	int sum = n/5;
	if(n % 5) sum++;
	cout << sum;
}