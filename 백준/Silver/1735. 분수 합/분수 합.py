import sys
input = sys.stdin.readline

def gcd(a, b): # 최대 공약수
    while b > 0:
        r = a % b
        a = b
        b = r
    return a

a1, b1 = map(int, input().split())
a2, b2 = map(int, input().split())

a3 = a1*b2 + a2*b1
b3 = b1*b2
n = gcd(a3, b3)

print(a3//n, b3//n)