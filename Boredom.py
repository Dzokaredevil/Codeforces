input()
d=[0]*100001
for x in map(int,input().split()):
    d[x]+=x
a=b=0 
for i in d:
    a,b=max(a,i+b),a
print(a)
