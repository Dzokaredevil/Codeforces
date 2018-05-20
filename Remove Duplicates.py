n = int(input())
r = []
for x in list(map(int, input().split()))[::-1]:
    if not x in r:
        r.append(x)
print(len(r))
print(*r[::-1])