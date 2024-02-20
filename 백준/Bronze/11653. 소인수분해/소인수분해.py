N = int(input())
k = 2

while k <= int(N**0.5):
    if N % k == 0:
        print(k)
        N //= k
    else:
        k += 1

if N > 1:
    print(N)