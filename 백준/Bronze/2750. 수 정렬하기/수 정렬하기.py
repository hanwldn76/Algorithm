n = int(input())
lst = list()

for i in range(n):
    lst.append(int(input()))

lst.sort()

print(*lst, sep="\n")