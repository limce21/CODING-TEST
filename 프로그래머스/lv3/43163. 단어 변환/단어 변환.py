from collections import deque

def bfs(word,graph, visited, answer):
    queue = deque([])
    queue.append(word)
    while queue:
        value = queue.popleft()
        for i in graph[value]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                temp = answer[value]
                answer[i] = temp + 1
        

def solution(begin, target, words):
    answer = 0
    graph = dict.fromkeys(words, [])
    visited = dict.fromkeys(words, False)
    answer = dict.fromkeys(words, 0)
    answer[begin] = 0
    length = len(words[0])
    arr = set()
    
    for other_word in words:
        cnt = 0
        for i in range(length):
            if begin[i] == other_word[i]:
                cnt += 1
        if cnt == length - 1:
            arr.add(other_word)
    graph[begin] = list(arr)
    
    for word in words:
        arr = set()
        for other_word in words:
            cnt = 0
            for i in range(length):
                if word[i] == other_word[i]:
                    cnt += 1
            if cnt == length - 1:
                arr.add(other_word)
        graph[word] = list(arr)
    
    bfs(begin, graph, visited, answer)
    if target in answer:
        answer = answer[target]
    else:
        answer = 0
    
    return answer