import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dic = {}
reverse_dic = {}

for i in range(1, n+1):
    s = input().strip()
    dic[i] = s
    reverse_dic[s] = i

for i in range(m):
    tmp = input().strip()
    if tmp.isdigit():
        print(dic[int(tmp)])
    else:
        print(reverse_dic[tmp])