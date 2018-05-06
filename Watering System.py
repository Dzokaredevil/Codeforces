R = lambda: map(int, input().split())

n, A, B = R()
s = list(R())
t = s[0]
s0 = sum(s)
s = sorted(s[1:])

x = t*A/B
#print(x)
res = len(s)

i = 0
while s0 > x:
    s0 -= s[res - i - 1]
    i += 1
print(i)