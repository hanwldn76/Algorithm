import sys

n = int(sys.stdin.readline())
info = []

for i in range(n):
    a, b = sys.stdin.readline().split()
    info.append([int(a), b])

info.sort(key=lambda x:x[0])

for i in info:
    print(*i)