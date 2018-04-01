#include <cstdio>
#include <iostream>
#include <cmath>
#include <algorithm>
#include <cstring>
#include <string>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <utility> 
#include <map> 

using namespace std;

#define fo(i,n,a) {for(int i = 0 ; i < n ; i++) cin >> a[i];}
#define fou(i,n,a) {for(int i = 0 ; i < n; i++) cout << a[i] <<"  ";}

#define F first
#define S second

typedef long long int ll;
int const _max = 1e5 + 5;


int BinarySearch(int a[], int left, int right, int x){
    if(left <= right){
        int mid = (left + right) / 2;

        while(left <= right){
            mid = (left + right) / 2;

            if(x == a[mid])
                return mid;
            else if(x > a[mid])
                left = mid - 1;
            else
                right = mid + 1;
        }
        return -1;
    }
}

void QuickSort(ll a[], ll b[], int left, int right){
    if(left <= right){
        int l = left;
        int r = right;
        int mid = a[(left + right) / 2];

        while(l <= r){
            while(a[l] < mid && ++l);
            while(a[r] > mid && --r);

            if(l <= r){
                swap(a[l],a[r]);
                swap(b[l],b[r]);
                l++;
                r--;
            }
        }
        if(left < r)
            QuickSort(a,b,left,r);
        if(l < right)
            QuickSort(a,b,l,right);

    }
}

int main()
{
    ll n;
    cin >> n;

    if(n%2)
        cout << -(n+1)/2;
    else
        cout << (n)/2;

}
