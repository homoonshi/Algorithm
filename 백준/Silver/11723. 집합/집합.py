import sys

n = int(sys.stdin.readline())

s = 0

for i in range(n):
    operate = sys.stdin.readline().split(" ")
    command = operate[0].rstrip()

    if command == 'add':
        s |= (1 << int(operate[1]))
        continue
    if command == 'remove':
        s &= ~(1 << int(operate[1]))
        continue
    if command == 'toggle':
        s ^= (1 << int(operate[1]))
        continue
    if command == 'all':
        for j in range(1, 21):
            s |= (1 << j)
        continue
    if command == 'empty':
        s = 0
        continue
    if s & (1 << int(operate[1])):
        print(1)
    else:
        print(0)
