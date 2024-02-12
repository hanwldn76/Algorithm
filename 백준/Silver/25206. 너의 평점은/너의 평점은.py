a = 0.0
b = 0.0
dic = {"A+":4.5, "A0":4.0, "B+":3.5, "B0":3.0, "C+":2.5, "C0":2.0, "D+":1.5, "D0":1.0, "F":0.0}

for i in range(20):
    lst = list(input().split())
    if lst[2] == "P":
        continue
    a += (float(lst[1])*dic.get(lst[2]))
    b += float(lst[1])

print(a/b)