a, b, c = input().split()

a, b, c = int(a), int(b), int(c)

print((a+b)%c,((a%c) + (b%c))%c, (a*b)%c, ((a%c) * (b%c))%c, sep="\n")