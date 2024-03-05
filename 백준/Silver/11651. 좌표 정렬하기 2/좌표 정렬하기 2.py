import sys

n = int(input())
x_y = list()

for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    tmp = row[0]
    row[0] = row[1]
    row[1] = tmp
    x_y.append(row)

x_y.sort()

for i in range(n):
    print(x_y[i][1], x_y[i][0])