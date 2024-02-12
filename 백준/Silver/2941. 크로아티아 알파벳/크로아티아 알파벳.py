c_alpha = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
s = input()

for i in c_alpha:
    s = s.replace(i, "_")

print(len(s))