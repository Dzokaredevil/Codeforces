n,m,a,b=map(int,input().split())
print(min(n*a,-n//m*-b,n//m*b+n%m*a)) 
