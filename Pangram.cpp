#include<iostream>
#include<algorithm>
#include<cstring>


using namespace std;

int main()
{
	bool arr[26];
    bool flag = true;
    for(int i = 0; i < 26; i++){
        arr[i] = 0;
    }
    int x;
    cin >> x;
    string str;
    cin >> str ;
    transform(str.begin(), str.end(), str.begin(), ::tolower);
    for(int i =0;i<x;i++){
         arr[str.at(i) - 97] = true;
	}
    for(int i=0;i<26;i++){
        if(arr[i]==0){
			flag=0;
        }
	}
    if(flag == 0)
		cout << "NO";
	else
		cout << "YES";
    return 0;
}