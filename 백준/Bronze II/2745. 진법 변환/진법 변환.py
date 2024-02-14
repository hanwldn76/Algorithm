num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
N, B = input().split()
N = N[::-1]
result = 0

for i in range(len(N)):
    result += num.index(N[i]) * (int(B) ** i)

print(result)