a = []
max_len = 0

for i in range(5):
    a_row = list(input())
    a.append(a_row)
    if max_len < len(a[i]):
        max_len = len(a[i])

for i in range(max_len):
    for j in range(5):
        if len(a[j]) > i:
            print(a[j][i], end="")