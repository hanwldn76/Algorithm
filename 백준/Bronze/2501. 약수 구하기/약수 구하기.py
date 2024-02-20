import math

N, K = map(int, input().split())

lst = []

for i in range(1, int(math.sqrt(N))+1):
    if N % i == 0:
        lst.append(i)
        if N / i != i:
            lst.append(int(N/i))

lst.sort()

try:
    print(lst[K-1])
except:
    print('0')