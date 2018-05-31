n,k=map(int,input().split())
ans=0
t=0
while t<=240-k:
    ans+=1
    t+=5*ans
print(min(n,ans-1))