n,x=map(int,input().split())
s=0
for _ in range(n):
    z,d=input().split();d=int(d)
    if z=='+':x+=d
    else:
        if x>=d:x-=d
        else: s+=1
print(x, s)