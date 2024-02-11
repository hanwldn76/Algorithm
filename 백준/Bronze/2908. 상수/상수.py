s1, s2 = input().split()

new_s1, new_s2 = s1[::-1], s2[::-1]

print(new_s1 if int(new_s1)>int(new_s2) else new_s2)