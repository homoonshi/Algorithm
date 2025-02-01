def isStr(user_input):
    if len(user_input) > 2 and user_input[0] == '"' and user_input[-1] == '"':
        return user_input[1:-1] 
    return None

user_input = input()

res = isStr(user_input)

if res is None:
    print("CE")
else:
    print(res)
