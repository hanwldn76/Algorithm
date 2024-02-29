n = int(input())

series = 666
cnt = 0

while True:
    if str(series).find('666') == -1:
        series += 1
        continue
    else:
        cnt += 1
        series += 1

    if cnt == n:
        print(series-1)
        break