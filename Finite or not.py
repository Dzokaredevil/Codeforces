from sys import stdin, stdout 

n=int(stdin.readline())
s=''
for i in range(n):
    p,q,b=map(int,input().split())
    for i in range(6):
        b=(b*b)%q
        
    if((p*b)%q):
        s+='Infinite\n'
    else:
        s+='Finite\n'
print(s)