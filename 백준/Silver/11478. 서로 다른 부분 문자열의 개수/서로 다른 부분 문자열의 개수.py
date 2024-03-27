import sys
input = sys.stdin.readline

s = input()
result = set()

cnt = 1
for i in range(1, len(s)+1):
    for j in range(len(s)-i):
        result.add(s[j:j+cnt])
    cnt += 1

print(len(result))