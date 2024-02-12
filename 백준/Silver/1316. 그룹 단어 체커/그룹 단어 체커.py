n = int(input())
c = n

for i in range(n):
    word = input()

    for j in range(len(word)-1):
        if word[j] == word[j+1]:
            pass
        elif word[j] in word[j+1:]:
            c -= 1
            break

print(c)