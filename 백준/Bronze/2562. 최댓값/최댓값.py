num_list = list()

index = 0
max = 0

for i in range(9):
    num_list.append(int(input()))
    if max < num_list[i]:
        max = num_list[i]
        index = i

print(num_list[index], index+1, sep="\n")