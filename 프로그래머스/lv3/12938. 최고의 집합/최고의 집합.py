def solution(n, s):
    answer = []
    if s // n <= 0: return [-1]
    answer = [s//n for _ in range(n)]
    if s % n != 0:
        for i in range(s%n):
            answer[i] +=1 
    
    answer.sort()
    return answer