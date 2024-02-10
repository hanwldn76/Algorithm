n, m = map(int, input().split())

lst = [i for i in range(1, n+1)]

for x in range(m):
    i, j = map(int, input().split())
    tmp = lst[i-1:j]
    tmp.reverse()
    lst[i-1:j] = tmp

for x in lst:
    print(x, end=" ")