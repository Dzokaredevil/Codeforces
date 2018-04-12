#include <bits/stdc++.h>
using namespace std;

int gcd(int a,int b) { return a ? gcd(b%a,a) : b;}

int main()
{
    vector <string> b;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++){
        string a;
        cin >> a;
        b.push_back(a);
    }
    b.erase(unique(b.begin(),b.end()),b.end());
    cout << b.size();
}