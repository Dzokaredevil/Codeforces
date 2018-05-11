n = int(input().split()[0])
a = list(map(int,input().split()))
r = sum((x+n-y)%n for x,y in zip(a,[1]+a))
print(r)