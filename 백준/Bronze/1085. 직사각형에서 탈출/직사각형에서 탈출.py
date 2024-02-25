x, y, w, h = map(int, input().split())

min1 = x if w-x > x else w-x
min2 = y if h-y > y else h-y

if min1 > min2:
    print(min2)
else:
    print(min1)