T = int(input())

change = [25, 10, 5, 1]

for i in range(T):
    C = int(input())
    for j in change:
        print(C//j, end=" ")
        C %= j
    print()