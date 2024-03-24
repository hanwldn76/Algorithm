import sys

n, m = map(int, sys.stdin.readline().split())
lst_n, lst_m = list(), list()

for i in range(n):
    lst_n.append(input())
for i in range(m):
    lst_m.append(input())

dic = {k: 0 for k in lst_n}

for i in lst_m:
    if i in dic:
        dic[i] += 1

print(sum(dic.values()))