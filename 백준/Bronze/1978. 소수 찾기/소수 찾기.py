def isPrime(x):
    if x == 1:
        return False
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    return True

n = int(input())
cnt = 0
lst = list(map(int, input().split()))

for i in lst:
    if isPrime(i):
        cnt += 1

print(cnt)