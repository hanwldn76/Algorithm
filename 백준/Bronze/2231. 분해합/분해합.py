n = int(input())
result = 0

for i in range(n//2, n):
    tmp = i
    j = 0
    while tmp:
        j += tmp % 10
        tmp //= 10
    if j+i==n:
        result = i
        break

print(result)