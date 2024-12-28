
nanjang = globals()
nanjang = list()

for i in range(9) :
    num = input()
    nanjang.append(int(num))

isSelected = globals()
isSelected = dict()

def combination(index, count, res):

    if (count == 7):
        if(res==100) :
            for i in range(9):
                if (isSelected[i]):
                    print(nanjang[i])
            return True
        else :
            return False
        
    if (index>=9) :
        return False

    isSelected[index] = True
    search = combination(index + 1, count + 1, res + nanjang[index])

    if (search):
        return True

    isSelected[index] = False
    search = combination(index + 1, count, res)

    return search

res = combination(0, 0, 0)
