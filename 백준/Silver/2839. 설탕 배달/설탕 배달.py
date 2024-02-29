n = int(input())
bag = 0

while n >= 0:
    if n % 5 == 0:
        bag += (n // 5)
        break
    n -= 3
    bag += 1

print(-1 if n<0 else bag)