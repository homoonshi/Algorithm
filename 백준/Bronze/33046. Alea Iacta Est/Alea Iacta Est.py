
position = 1

for i in range(2) :
    a, b = input().split(" ")
    position += int(a) + int(b) - 1
    position %= 4
    if(position==0):
        position = 4

print(position)