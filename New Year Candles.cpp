#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int a, c, i, j;
    int b; 
    cin >> a;
    cin >> b;
    int sum = a;

    int p = a;
    int y = a;
    while(y >= b){
        a = y/b;
        y = y%b;
        sum = sum+a;
        y = y+a;
    }
    cout << sum;
}