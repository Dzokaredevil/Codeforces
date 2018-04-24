a=int(input().split()[1])
b=[0]+list(map(int,input().split()))
i=1 
while i<a:
    i=i+b[i]
print('YES'if i==a else'NO')
