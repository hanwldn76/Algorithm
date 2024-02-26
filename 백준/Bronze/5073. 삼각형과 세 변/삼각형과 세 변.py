while True:
    x = []
    x = list(map(int, input().split()))
    x.sort()

    if x[0]+x[1]+x[2]==0:
        break

    if x[0] == x[1] == x[2]:
        print("Equilateral")
    elif x[2] < x[0]+x[1]:
        if x[0] == x[1] or x[0] == x[2] or x[1] == x[2]:
            print("Isosceles")
        else:
            print("Scalene")
    else:
        print("Invalid")