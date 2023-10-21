from collections import deque

def can_change(key, words):
    change_list = []
    for word in words:
        cnt = 0
        for i in range(len(key)):
            if word[i] == key[i]:
                cnt += 1
        if cnt == len(key) - 1:
            change_list.append(word)
    return change_list
    

def solution(begin, target, words):
    answer = 0
    d = dict.fromkeys(words, [])
    visited = dict.fromkeys(words, False)
    d[begin] = can_change(begin, words)
    for word in words:
        d[word] = can_change(word, words)

    queue = deque([])
    queue.append((begin, 0))
    visited[begin] = True
    while queue:
        w, c = queue.popleft()
        if w == target:
            answer = c
            return answer
        for nw in d[w]:
            if not visited[nw]:
                visited[nw] = True
                queue.append((nw, c+1))
    
    return 0