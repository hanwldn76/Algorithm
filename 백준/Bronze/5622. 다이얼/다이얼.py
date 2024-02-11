dic = {"ABC":3, "DEF":4, "GHI":5, "JKL":6, "MNO":7, "PQRS":8, "TUV":9, "WXYZ":10}
time = 0

s = input()

for i in s:
    for key in dic.keys():
        if key.find(i) != -1:
            time += dic.get(key)

print(time)