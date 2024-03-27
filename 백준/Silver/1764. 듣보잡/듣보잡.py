import sys
input = sys.stdin.readline

n, m = map(int, input().split())
non_listen = set()
non_seen = set()
cnt = 0

for i in range(n):
    non_listen.add(input().rstrip())

for i in range(m):
    non_seen.add(input().rstrip())

lst = sorted(list(non_listen & non_seen))

print(len(lst))
print(*lst, sep="\n")