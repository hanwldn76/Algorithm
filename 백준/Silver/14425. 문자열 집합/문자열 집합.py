import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dic = {}

for i in range(n):
    tmp = input()
    dic[tmp] = 0

count = 0
for i in range(m):
    tmp = input()
    if tmp in dic:
        count += 1

print(count)