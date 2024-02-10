n = int(input())
result = 0
lst = list(map(int, input().split()))
m = max(lst)

for i in range(n):    
    lst[i] = lst[i] / m * 100
    result += lst[i]

print(result/n)