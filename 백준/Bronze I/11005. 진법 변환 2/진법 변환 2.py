num = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
result = ""
N, B = map(int, input().split())

while N > 0:
    result += num[N%B]
    N = N // B

result = result[::-1]
print(result)