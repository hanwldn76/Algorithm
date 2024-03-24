import sys
input = sys.stdin.readline

n = int(input())
lst_n = map(int, input().split())
m = int(input())
lst_m = map(int, input().split())
chk = [0]*m

dic = dict(zip(lst_m, chk))

for i in lst_n:
    if i in dic.keys():
        dic[i] = 1
    
print(*dic.values())