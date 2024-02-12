chess = [1, 1, 2, 2, 2, 8]

chess_white = list(map(int, input().split()))

for i in range(len(chess)):
    chess_white[i] -= chess[i]
    chess_white[i] *= -1

print(*chess_white)