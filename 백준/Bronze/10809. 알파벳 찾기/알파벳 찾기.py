str = input()
lst = [-1]*26

dic = dict()

for i in str:
    dic[i] = str.index(i)
dic = dict(sorted(dic.items()))

for key in dic.keys():
    for i in range(len(lst)):
        if ord(key)-ord('a') == i:
            lst[i] = dic[key]

print(*lst)