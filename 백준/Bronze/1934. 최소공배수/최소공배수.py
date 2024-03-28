import sys
input = sys.stdin.readline

def gcd(a, b): # 최대 공약수
    while b > 0:
        r = a % b
        a = b
        b = r
    return a

def lcm(a, b): # 최소 공배수
    return a * b // gcd(a,b)

t = int(input())

for i in range(t):
    a, b = map(int, input().split())
    print(lcm(a,b))