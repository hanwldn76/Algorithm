array = [[0 for col in range(9)] for row in range(9)]
for i in range(9):
    array[i] = list(map(int, input().split()))

r_index = 0
c_index = 0
max = 0

for i in range(9):
    for j in range(9):
        if array[i][j] > max:
            max = array[i][j]
            r_index = i
            c_index = j

print(max)
print(r_index+1, c_index+1)