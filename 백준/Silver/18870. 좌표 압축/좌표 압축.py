import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))

sorted_lst = sorted(list(set(lst)))
dic = {x:idx for idx, x in enumerate(sorted_lst)}

for i in lst:
    print(dic[i], end=" ")