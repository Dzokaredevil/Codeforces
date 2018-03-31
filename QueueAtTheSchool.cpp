#include <bits/stdc++.h>

using namespace std;

#define all(k) ((k).begin()),((k).end())
#define all(v) ((v).begin()),((v).end())

int main()
{
    string u, g = "";
    int i = 0,j = 0, x, y;
    vector<string> xoox;
    cin >> x >> y;
    cin >> u;
    while(i < y){
        while(j < x){
            if(j+1 == x){
                g = g + u[j];
                xoox.push_back(g);
                break;
            } else {
                if(u[j] == 'B' && u[j+1] == 'G'){
                    g = g + 'G';
                    g = g + 'B';
                    if(j+2 == u.size()){
                        break;
                    } else {
                        j = j+2;
                    }
                } else if(u[j]=='G'&&u[j+1]=='G') {
                    g = g+'G';
                    if (j+2 == u.size()) {
                        g = g+'G';
                        break;
                    } else {
                        j = j+1;
                    }
                } else if(u[j] == 'B' && u[j+1] == 'B') {
                    g = g + 'B';
					
                    if (j+2 ==u.size()){
                        g = g + 'B';
                        break;
                    } else {
                        j = j + 1;
                    }
                } else if (u[j] == 'G' && u[j+1] == 'B') {
                    g = g + 'G';
                    if(j+2==u.size()){
                       g = g+'B';
                       break;
                    } else {
                       j=j+1;
                   }
               
			    }
            }
        }
        xoox.push_back(g);
        u = g;
        g = "";
        j = 0;
        i = i+1;
    }
    cout << xoox[xoox.size() - 1];
    
    return 0;
}
