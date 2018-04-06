#include <bits/stdc++.h>

using namespace std;

int main() {
	int no_row,no_col,no_del,the_win = 0;

	cin >> no_row >> no_col;
	while (no_row > 0 && no_col > 0){
		no_col--;
		no_row--;
		the_win++;
	}

	if (the_win%2 == 0){
		cout << "Malvika";
	} else {
		cout << "Akshat";
	}
	return 0;
}