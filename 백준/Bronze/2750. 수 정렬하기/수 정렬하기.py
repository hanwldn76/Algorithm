n = int(input())
lst = []

for i in range(n):
    lst.append(int(input()))

for i in range(n):
    for j in range(n-1):
        if lst[j] > lst[j+1]:
            tmp = lst[j]
            lst[j] = lst[j+1]
            lst[j+1] = tmp
            
print(*lst, sep="\n")