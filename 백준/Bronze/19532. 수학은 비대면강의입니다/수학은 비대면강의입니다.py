a, b, c, d, e, f = map(int, input().split())

x = (c*e - f*b)//(a*e - d*b)
y = (f*a - c*d)//(e*a - b*d)

print(x, y)