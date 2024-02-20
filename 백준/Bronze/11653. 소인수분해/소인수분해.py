N = int(input())
k = 2

while N > 1:
    if N % k == 0:
        print(k)
        N //= k
    else:
        k += 1