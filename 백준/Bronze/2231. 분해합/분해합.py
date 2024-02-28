n = int(input())
result = 0

for i in range(1, n):
    lst = []
    tmp = i
    while tmp > 0:
        lst.append(tmp%10)
        tmp //= 10
    if i+sum(lst)==n:
        result = i
        break

print(result)