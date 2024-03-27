import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dic = {}

for i in range(n+m):
    tmp = input().rstrip()
    if tmp in dic:
        dic[tmp] += 1
    else:
        dic[tmp] = 1

lst = []

for i in dic.keys():
    if dic[i] == 2:
        lst.append(i)

lst.sort()

print(len(lst))
print(*lst, sep="\n")