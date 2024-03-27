import sys
input = sys.stdin.readline

n, m = map(int, input().split())
a = set()
result = []

for i in range(n):
    a.add(input().rstrip())

for i in range(m):
    name = input().rstrip()
    if name in a:
        result.append(name)

result.sort()

print(len(result))
print(*result, sep="\n")