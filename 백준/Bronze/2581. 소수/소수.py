def isPrime(x):
    if x == 1:
        return False
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    return True

M = int(input())
N = int(input())

lst = []

for i in range(M, N+1):
    if isPrime(i):
        lst.append(i)

try:
    print(sum(lst), min(lst), sep="\n")
except:
    print('-1')