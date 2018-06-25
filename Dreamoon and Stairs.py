n,m=map(int,input().split())
t=(n+1)//2
s=(t-1)//m*m+m
print([s,-1][s>n])