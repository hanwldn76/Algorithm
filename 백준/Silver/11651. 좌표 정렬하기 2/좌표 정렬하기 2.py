import sys

n = int(sys.stdin.readline())
x_y = []

for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    x_y.append(row)

x_y.sort(key=lambda x:(x[1], x[0]))

for i in x_y:
    print(*i)