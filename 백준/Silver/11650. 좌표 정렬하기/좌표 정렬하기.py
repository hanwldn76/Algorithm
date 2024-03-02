n = int(input())
x_y = list()

for i in range(n):
    row = list(map(int, input().split()))
    x_y.append(row)

x_y.sort()

for i in x_y:
    print(*i)