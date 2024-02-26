a = int(input())
b = int(input())
c = int(input())

sum = a+b+c

if a == 60 and b == 60 and c == 60:
    print("Equilateral")
elif sum == 180:
    if a == b or a == c or b == c:
        print("Isosceles")
    else:
        print("Scalene")
else:
    print("Error")