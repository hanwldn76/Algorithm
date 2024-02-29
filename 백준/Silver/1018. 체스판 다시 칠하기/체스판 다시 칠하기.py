m, n = map(int, input().split())
my_chess = []
cnt = []

for row in range(m):
    array_row = list(input())
    my_chess.append(array_row)

for i in range(m-7):
    for j in range(n-7):
        tmp = 0

        for k in range(i, i+8):
            for l in range(j, j+8):
                if (k+l) % 2 == 0:
                    if my_chess[k][l] != 'W':
                        tmp += 1
                else:
                    if my_chess[k][l] != 'B':
                        tmp += 1

        cnt.append(min(tmp, 64-tmp))

print(min(cnt))