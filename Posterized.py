n, k = [int(x) for x in input().split()]
ps = [int(x) for x in input().split()]
mapping = [-1 for _ in range(256)]

res = []
for p in ps:
    if mapping[p] == -1:
        j = p - k + 1
        while j < 0 or (mapping[j] != -1 and mapping[j] + k <= p):
            j += 1
        for i in range(j, p+1):
            mapping[i] = j
    res.append(mapping[p])
print(" ".join(map(str, res)))