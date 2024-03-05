import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))

sorted_lst = sorted(list(set(lst)))
idx_lst = [i for i in range(len(sorted_lst))]

dic = dict(zip(sorted_lst, idx_lst))

for i in lst:
    print(dic[i], end=" ")