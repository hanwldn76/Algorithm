import sys

n = int(sys.stdin.readline())
word = []

for i in range(n):
    word.append(input())

word.sort(key=lambda x:(len(x), x))

print(word[0])
for i in range(1, n):
    if word[i-1] == word[i]:
        continue
    print(word[i])