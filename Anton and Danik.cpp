#include <string>
#include <vector>
#include <map>
#include <list>
#include <iterator>
#include <cassert>
#include <set>
#include <queue>
#include <iostream>
#include <sstream>
#include <stack>
#include <deque>
#include <cmath>
#include <memory.h>
#include <cstdlib>
#include <cstdio>
#include <cctype>
#include <algorithm>
#include <utility>
#include <time.h>
#include <complex>
#include <fstream>
#include <tuple>
#include <iomanip>

using namespace std;

#define forn(i, n) for (int i = 0; i < int(n); ++i)
#define for1(i, n) for (int i = 1; i < int(n); ++i)
#define ford(i, n) for (int i = int(n) - 1; i >= 0; --i)
#define fore(i, l, r) for (int i = int(l); i <= int(r); ++i)
#define all(a) a.begin(), a.end()
#define sz(a) (int(a.size()))
#define mp make_pair
#define pb push_back
#define ft first
#define sc second
#define g(a, b) get<a> (b)
#define _ ?

typedef long long ll;
typedef long double ld;
typedef pair<int, int> pt;

const int MAX_N = 1e5 + 5;
const long double ost = 1e-9;

int main()
{
    #if 0
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif
    #if 0
        cout << setprecision(20);
    #endif
    int n;
    string s;
    int time1 =0, time2 = 0;
    cin >> n;
    cin >> s;
    for (int i = 0 ;i < s.size(); i++)
        if (s[i] == 'A') time1++;
    else time2++;
    
    if (time1 > time2){
        cout << "Anton";
    }
    else if (time2 > time1) {
        cout << "Danik";
    }
    else cout << "Friendship";
    return 0;
}