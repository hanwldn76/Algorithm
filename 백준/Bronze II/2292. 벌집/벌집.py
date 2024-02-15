N = int(input())
num = 1
cnt = 1

while N > num:
    num += cnt*6
    cnt += 1

print(cnt)