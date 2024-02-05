h, m = input().split()
h, m = int(h), int(m)
time = int(input())

m += time

h += m // 60
m %= 60

if h > 23:
    h -= 24

print(h, m)