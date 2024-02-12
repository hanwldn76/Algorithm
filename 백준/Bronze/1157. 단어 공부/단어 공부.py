lst1 = list(input().lower())
lst2 = list(set(lst1))
dic = dict()

for i in lst2:
    dic[i] = lst1.count(i)

max_values = max(dic.values())
cnt = 0
ch = ''

for k in dic.keys():
    if max_values == dic.get(k):
        cnt += 1
        ch = k

print(ch.upper() if cnt == 1 else '?')