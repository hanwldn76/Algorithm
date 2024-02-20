import math

while(True):
    n = int(input())

    if n == -1:
        break

    lst = []

    for i in range(1, int(math.sqrt(n))+1):
        if n % i == 0:
            lst.append(i)
            if n / i != i:
                lst.append(int(n/i))
    
    lst.sort()
    lst.pop()

    if n == sum(lst):
        print(n,  "=", end=" ")
        print(*lst, sep=" + ")
    else:
        print(n, "is NOT perfect.")