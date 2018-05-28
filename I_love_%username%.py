n=int(input())
l=list(map(int,input().split()))
u=0
for i in range(1,n):
    if l[i]>max(l[:i]) or l[i]<min(l[:i]): u+=1
print(u)