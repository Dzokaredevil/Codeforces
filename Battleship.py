n, k = map(int, input().split())
m = []
for i in range(n):
    u = str(input())
    m.append(u)
v = [[0] * n for _ in range(n)]
for x in range(n - k + 1):
    for y in range(n):
        s = m[y][x:x+k]
        if not '#' in s:
            for i in range(k):
                v[y][x + i] += 1
for x in range(n):
    for y in range(n - k + 1):
        o = m[y:y+k]
        s = [o[q][x] for q in range(k)]
        if not '#' in s:
            for i in range(k):
                v[y + i][x] += 1
mx = 0
my = 0
m = v[0][0]
for i in range(n):
    for q in range(n):
        if v[i][q] > m:
            mx = q
            my = i
            m = v[i][q] 
print(my + 1, mx + 1)
