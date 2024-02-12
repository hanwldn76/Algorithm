s = input().upper()
word = list(set(s))
cnt = [s.count(i) for i in word]

if cnt.count(max(cnt)) > 1:
    print('?')
else:
    print(word[cnt.index(max(cnt))])