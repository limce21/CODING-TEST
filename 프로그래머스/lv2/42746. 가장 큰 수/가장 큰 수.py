def solution(numbers):
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x : (x*4)[:4], reverse=True)
    answer = ''.join(numbers)
    if answer[0] == '0':
        answer = '0'
    return answer