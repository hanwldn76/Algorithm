a = int(input())
b = input()

b_len = len(b)-1

while b_len>-1:
    x = a*int(b[b_len])
    b_len -= 1
    print(x)

print(a * int(b))
