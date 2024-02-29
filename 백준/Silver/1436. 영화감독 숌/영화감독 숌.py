n = int(input())

series = 666
cnt = 0

while True:
    if '666' in str(series):
        cnt += 1
    if cnt == n:
        break
    series += 1

print(series)