#include <iostream>
#include <string>
#include <cmath>
#include <iomanip>
#include <iterator>
#include <algorithm>
#include <map>
#include <vector>

using namespace std;
long int arr[1000001];

int main()
{
	string word;
	int a;
	cin >> word;
	a = word.find("WUB");
	while (a != -1){
		word.replace(a, 3, " ");
		a = word.find("WUB");
	}
	cout << word;
}