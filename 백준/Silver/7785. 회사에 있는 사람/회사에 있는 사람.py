import sys
input = sys.stdin.readline

n = int(input())
dic = {}

for i in range(n):
    name, state = input().split()
    if state == 'enter':
        dic[name] = state
    else:
        del dic[name]

dic = sorted(dic.keys(), reverse=True)

print(*dic, sep='\n')