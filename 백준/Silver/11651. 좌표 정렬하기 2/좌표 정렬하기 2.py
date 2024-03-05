import sys

n = int(input())
x_y = []

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    x_y.append([a, b])

x_y.sort(key=lambda x:(x[1], x[0]))

for i in x_y:
    print(*i)