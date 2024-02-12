c_alpha = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
cnt = 0
s = input()

for i in c_alpha:
    cnt += s.count(i)
    s = s.replace(i, " ")
s = s.replace(" ", "")

print(cnt+len(s))