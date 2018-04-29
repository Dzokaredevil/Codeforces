n, A, B, C, T = map(int, input().split())
t = sum(list(map(int, input().split())))
if C - B < 0:
    print(n * A) 
else:
    print(n * A + (C - B) * (n * T - t))
