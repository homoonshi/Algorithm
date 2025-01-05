
A, B, V = input().split(" ")

V = int(V)
A = int(A)
B = int(B)

day = A-B

remain = int((V-B)%day)
day = int((V-B)/day)

if remain != 0 :
    day+=1
    
print(day)