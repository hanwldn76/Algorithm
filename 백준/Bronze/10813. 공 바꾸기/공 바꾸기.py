n, m = map(int, input().split())

lst = list()

for x in range(n):
    lst.append(x+1)

for x in range(m):
    i, j = map(int, input().split())
    tmp = lst[i-1]
    lst[i-1] = lst[j-1]
    lst[j-1] = tmp

for x in lst:
    print(x, end=" ")