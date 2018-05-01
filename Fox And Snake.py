n, m = map(int, input().split())
a = ["#" * m, "." * (m - 1) + "#", "#" * m, "#" + "." * (m - 1)]
for i in range(n):
    print(a[i % 4])