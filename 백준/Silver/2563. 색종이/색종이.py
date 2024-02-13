paper = [[0 for i in range(100)] for j in range(100)]

n = int(input())

for i in range(n):
    x, y = map(int, input().split())
    for j in range(x, x+10):
        for k in range(y, y+10):
            if paper[j][k] == 0:
                paper[j][k] = 1
            else:
                pass

sum_paper = 0

for i in range(100):
    sum_paper += sum(paper[i])

print(sum_paper)