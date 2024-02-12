str = input()

result = 1
str_len = len(str)

for i in range(0, str_len//2):
    if str[i] != str[str_len-i-1]:
        result = 0
        break

print(result)