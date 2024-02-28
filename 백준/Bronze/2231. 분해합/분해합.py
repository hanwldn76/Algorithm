n = int(input())
result = 0

for i in range(n//2, n):
    s = str(i)
    sum = 0
    for j in range(len(s)):
        sum += int(s[j])
    if i+sum==n:
        result = i
        break

print(result)