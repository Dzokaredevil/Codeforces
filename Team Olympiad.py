n = int(input()) 
t = [[], [], []]
for i, x in enumerate(int(x) for x in input().split()):
    t[x - 1].append(i + 1)
nt = min(len(x) for x in t)
print(nt)
for i in range(nt):
    print(t[0][i], t[1][i], t[2][i])
