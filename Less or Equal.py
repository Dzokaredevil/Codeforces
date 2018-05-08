n, k = map(int, input().split())
a = [int(i) for i in input().split()]
a.sort()
try:
    if k==0 and a[0]>1: print(a[0]-1) 
    elif a[k]-1>=a[k-1]: print(a[k]-1)
    else: print(-1)
except IndexError:
    print(a[n-1])
