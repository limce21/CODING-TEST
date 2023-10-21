def check(arr, ans):
    cnt = 0
    for i in range(len(arr)):
        if arr[i] == ans[i]:
            cnt += 1
    return cnt

def solution(answers):
    answer = []
    max_value = 0
    p = [[], [1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    for i in range(1, 4):
        if len(answers) < len(p[i]):
            arr = p[i][:len(answers)]
        elif len(answers) == len(p[i]):
            arr = p[i]
        else:
            q = len(answers) // len(p[i])
            r = len(answers) % len(p[i])
            arr = p[i] * q + p[i][:r]
        cnt = check(arr, answers)
        if cnt > max_value:
            answer = [i]
            max_value = cnt
        elif cnt == max_value:
            answer.append(i)
        
    return answer