s1, s2 = input().split()
l, r = 0, len(s1)-1
new_s1, new_s2 = "", ""
for i in range(len(s1)):
    new_s1 += s1[-i-1]
for i in range(len(s2)):
    new_s2 += s2[-i-1]

print(new_s1 if int(new_s1)>int(new_s2) else new_s2)