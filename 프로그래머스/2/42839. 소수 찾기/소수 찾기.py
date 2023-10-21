import math
number_set = set()
n = 0

def make(numbers, idx, string, visited):
    if idx == n:
        if string != '':
            number_set.add(int(string))
        return
    for i in range(len(numbers)):
        if not visited[i]:
            visited[i] = True
            make(numbers, idx+1, string, visited)
            make(numbers, idx+1, string+numbers[i], visited)
            make(numbers, idx+1, numbers[i]+string, visited)
            visited[i] = False;

def solution(numbers):
    global n
    n = len(numbers)
    answer = 0
    visited = [False] * (n)

    make(numbers, 0, "", visited)
    number_list = list(number_set)
    
    max_value = max(number_list)
    arr = [True for i in range(max_value+1)]
    arr[0] = False
    arr[1] = False

    for i in range(2, int(math.sqrt(max_value))+1):
        if arr[i] == True:
            j = 2
            while i * j <= max_value:
                arr[i*j] = False
                j += 1
    
    for number in number_list:
        if arr[number]:
            print(number)
            answer += 1
    
    return answer