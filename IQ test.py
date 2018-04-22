input()
a = [int(x) % 2 for x in input().split()]
print(a.index(int(a.count(1) == 1)) + 1)