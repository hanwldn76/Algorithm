n, m = map(int, input().split())

lst = [0]*n

for x in range(m):
    i, j, k = map(int, input().split())
    for y in range(i-1, j):
        lst[y] = k

for x in lst:
    print(x, end=" ")