lst = [0]*30

for i in range(28):
    lst[int(input())-1] = 1

for i in range(len(lst)):
    if lst[i] == 0:
        print(i+1, end=" ")