x=input()
m=123
t=0
for i in range(int(x)):
    a,b=map(int,input().split())
    m=min(m,b)
    t=t+a*m
print(t)