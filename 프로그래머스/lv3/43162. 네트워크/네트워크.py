def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            dfs(i, computers, visited)
            answer += 1
    
    return answer

def dfs(n, computers, visited):
    for i in range(len(computers[n])):
        if computers[n][i] == 0:
            continue
        if visited[i]:
            continue
        if computers[n][i] == 1 and not visited[i]:
            visited[i] = True
            dfs(i, computers, visited)
    
        
            