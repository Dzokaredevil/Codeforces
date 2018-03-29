#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <set>
#include <map>
#include <cmath>
#include <stack>
#include <queue>
#include <list>
#include <functional>
#include <vector>
using namespace std;

bool b[100][100];

struct node{
      int value;
      node *left;
      node *right;
};

node* insert(node *p_tree , int key){
    if(p_tree == NULL){
		node *p_new_tree = new node;
        p_new_tree->left = p_new_tree->right = NULL;
        p_new_tree->value = key;
        return p_new_tree;
    }

    if(key < p_tree->value){
        p_tree->left = insert(p_tree->left ,key);
    } else if(key > p_tree->value){
            p_tree->right = insert(p_tree->right ,key);
    }
	return p_tree;
}

node * search(node *p_tree ,int key){
      if(p_tree == NULL)
      {
          return NULL;
      }

      if(p_tree->value == key)
      {
          return p_tree;
      }


      if(key > p_tree->value)
      {
         return search(p_tree->right,key);
      }
      else
        if(key < p_tree->value){
         return search(p_tree->left ,key);
      }
}

void show(node *p){
    if(p != NULL){
        cout << p->value << " ";
        show(p->left);
        show(p->right);
    }
}

int p[100];//prices
int f[100];//flavors
int cache[10000][1000];

multiset<int> v;

int cc(int s[1000], int N,int n){
    if(cache[N][n] != -1){
		return 0;
    }
  
	if(N == 0){
       return 1;
    }
	  
    if(N < 0){
       return 0;
    }

    if(n <= 0 ){
        cout << 1 << endl;
		return 0;
    }

    return cache[N][n] = cc(s ,N - s[n - 1] ,n) + cc(s ,N ,n - 1);
}

int sum = 0;
int c = 0;
int sol = 0;
vector<int> r;
int n; // the length of the tape
int so[100];

bool check(int s[100],int sum, int t){
    if(sum <= t){
        if(sum > sol){
            cout <<"sum "<< sum << endl;
            r.clear();
            sol = sum;
            for(int i = 0; i < c ;i++){
                r.push_back(so[i]);
            }
        }
        return true;
    }
    else
    return false;
}

void solve(int a[100] ,int x,int n ,int t){
	for(int i = x; i < n ;i++){
        sum += a[i];
        so[i] = a[i];
        cout << sum << endl;
        c++;
        if(check(a, sum, t)){
            solve(a ,i + 1 ,n ,t);
        }
        sum -= a[i];
        so[i] = 0;
		cout <<"minus sum "<< sum << endl;
    }
    return;
}

int ma;

int main()
{
	int n; // number of the rooms
	int p[100]; // number of people who live in room i
	int q[100]; // capacity of room i
	int c = 0;
	cin >> n;
	for(int i = 0; i < n ;i++){
		cin >> p[i] >> q[i];
		if(q[i] >= p[i] + 2){
			c++;
		}	
	}
    cout << c;
    return 0;
}
