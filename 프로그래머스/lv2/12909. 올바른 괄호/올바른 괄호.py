def solution(s):
    answer = True
    stack = []
    for i in list(s):
        if i == '(':
            stack.append(0)
        else:
            if len(stack) == 0:
                answer = False
                break
            stack.pop()

    if len(stack) != 0:
        answer = False
    
    return answer