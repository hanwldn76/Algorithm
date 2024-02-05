h, m = input().split()

h, m = int(h), int(m)

m -= 45
if m < 0:
    h -= 1
    if h < 0:
        h = 23
    m += 60

print(h, m)