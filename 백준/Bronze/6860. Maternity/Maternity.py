from sys import stdout

mother = input()
father = input()
num = int(input())
bio = list()

for i in range(10) :
    if (i%2==0) :
        if(mother[i].isupper() or father[i].isupper()) :
            bio.append(mother[i].upper())
            continue
    if (i%2==1) :
        if(mother[i].islower() and father[i].islower()) :
            bio.append(mother[i].lower())
            continue

for i in range(num) :
    child = input()
    count = 0
    for j in range(5) :
        if (child[j] in bio) :
            count += 1
        else :
            stdout.write("Not their baby!")
            stdout.write("\n")
            break
    if (count == 5):
        stdout.write("Possible baby.")
        stdout.write("\n")