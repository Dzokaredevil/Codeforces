I=lambda:list(map(int,input().split()))
n,k=I()
h=I()
m=t=sum(h[:k])
a=1
for i in range(k,n):
    t+=h[i]-h[i-k]
    if t<m:a=i-k+2;m=t
print(a)