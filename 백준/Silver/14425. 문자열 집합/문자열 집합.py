import sys

n, m = map(int, sys.stdin.readline().split())
s = set()

for i in range(n):
    tmp = input()
    s.add(tmp)

count = 0
for i in range(m):
    tmp = input()
    if tmp in s:
        count += 1

print(count)