a, b, c = input().split()
a, b, c = int(a), int(b), int(c)

answer = 0

if a == b == c:
    answer = 10000+a*1000
elif a == b or a == c:
    answer = 1000+a*100
elif b == c:
    answer = 1000+b*100
elif a != b != c:
    answer = max(a, b, c)*100

print(answer)