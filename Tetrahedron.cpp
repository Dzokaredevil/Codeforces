#include <iostream>
#include <algorithm>

using namespace std;

long long n,a = 1, b, c, i;

main(){
	cin >> n;
	while(i < n-1){
	    c = b;
		b = (3*a)%1000000007;
		a = (2*a + c)%1000000007;
		i++;
	}
	cout << b;
}