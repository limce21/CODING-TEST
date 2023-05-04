def solution(s):
    s_list = list(s)
    result = []
    for i in range(len(s)):
        if i == 0 or s_list[i-1] == ' ':
            result.append(s_list[i].upper())
        elif i == ' ':
            result.append(s_list[i])
        else:
            result.append(s_list[i].lower())
    answer = ''.join(result)
    return answer