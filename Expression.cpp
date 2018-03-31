#include <iostream>
#include <math.h>
#include <algorithm>
#include <string>
#include <sstream>
#include <climits>

#define  FOR(n , array) for(int i = 0 ; i < n ; i++)cout << array[i] << endl;
#define  MAX_N 100100

using namespace std;

void load(string s , int *arr){
    for(int i = 0 ; i < s.length(); i++)
        (*(arr + s[i]))++;
}

inline int SUM(int n , int a[100100]){
    int sum = 0;
    for(int i = 0 ; i < n ; i++)
        sum += a[i];
    return sum;
}

int getIsSolveable(){
    int in;
    int sum = 0;
    for(int i = 0 ; i <  3 ; i++){
        cin >> in;
        if(in)
            sum++;
    }
    return sum > 1 ? 1 : 0;
}
void solve(int elements[MAX_N] , int n , int k){
    for(int i = 0 ; i < k ; i++){

    }
}
int* getArray(int number){
    int n = ((int)log10(number)) + 1;
    int new_array[n];
    for(int i = n - 1 ; i >= 0 ; i--){
       new_array[i] = number % 10;
       number /= 10;
    }
    return new_array;
}

void removeWub(string s){
    int z = 0;
    int current_i = 0;
    if(!s.substr(0 , 3).compare("WUB")){
        z = 3;
        for(int i = 3 ; i < s.length() ; i += 3 , z+=3){
            if(i+3 > s.length())
                break;
            if(s.substr(i , 3).compare("WUB") != 0)
                break;
        }
        s.replace(0 , z , "");
    }
    if(s.length() - 3 >= 0 && s.length() >= 3){
        if(!s.substr(s.length() - 3 , 3).compare("WUB")){
            z = s.length() - 3;
            for(int i = s.length() - 6 ; i >= 0 ; i -= 3 , z -= 3){
                if(i < 0 || i + 3 > s.length())
                    break;
                if(s.substr(i , 3).compare("WUB") != 0){
                    break;
                }
            }
            s.replace(z , s.length()  , "");
        }
    }

    z = 0;
    bool found = false;
    for(int i = 0 ; i < s.length(), s.length() >=3,i + 3 <= s.length();){
        if(!s.substr(i , 3).compare("WUB") && !found){
            found = true;
            z = i;
            i+=3;
            current_i++;
        }else if(!s.substr(i , 3).compare("WUB")){
            i+=3;
            current_i++;
        }else if(found){
            s.replace(z , i - z , " ");
            i = z - 1;
            found = false;
            current_i = 0;
        }else{
            i++;
        }
    }
    if(found){
        s.replace(z , 3 * current_i, " ");
    }
    cout << s;
}

int main()
{
    int a,b,c;
    cin >> a >> b >> c;
    int max = 0;
    if(a + b*c > max)
        max = a+(b*c);
    if(a + b + c > max)
        max = a + b + c;
    if(a * b * c > max)
        max = a * b * c;
    if(a * (b + c) > max)
        max = a * (b + c);
    if((a+b) * c > max)
        max = (a + b) * c;
    if((a * b) + c > max)
        max = (a * b) + c;
    cout << max;
}