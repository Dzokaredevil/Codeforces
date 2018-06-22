#include<cstdio>

int n, a, b, ans;

int main() {
	scanf("%d",&n);
	while (n--) scanf("%d%d",&a,&b), ans+=(a>b)-(a<b);
	puts(ans==0?"Friendship is magic!^^":ans>0?"Mishka":"Chris");
} 
