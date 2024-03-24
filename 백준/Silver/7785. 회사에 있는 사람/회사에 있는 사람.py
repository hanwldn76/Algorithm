import sys
input = sys.stdin.readline

n = int(input())
dic = {}
lst = []

for i in range(n):
    a, b = input().split()
    dic[a] = b

for i in dic.keys():
    if dic[i] == 'enter':
        lst.append(i)

lst.sort(reverse=True)
print(*lst, sep="\n")