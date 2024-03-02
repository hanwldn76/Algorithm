lst = list()

for i in range(5):
    lst.append(int(input()))

avg = sum(lst)//5
lst.sort()

print(avg, lst[2], sep="\n")