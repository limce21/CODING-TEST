from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1] * 102 for _ in range(102)]
    
    for r in rectangle:
        lx, ly, rx, ry = map(lambda x : x*2, r)
        for i in range(lx, rx+1):
            for j in range(ly, ry+1):
                if lx < i < rx and ly < j < ry:
                    graph[i][j] = 0
                elif graph[i][j] != 0:
                    graph[i][j] = 1
                    
    
    dx = [0,0,-1,1]
    dy = [-1,1,0,0]
    
    queue = deque([])
    queue.append((characterX*2, characterY*2))
    visited = [[1] * (102) for _ in range(102)]
    visited[characterX*2][characterY*2] = 0
    
    while queue:
        vx, vy = queue.popleft()
        if vx == itemX * 2 and vy == itemY*2:
            answer = visited[vx][vy] // 2
            break
        for i in range(4):
            nx = vx + dx[i]
            ny = vy + dy[i]
            if visited[nx][ny] == 1 and graph[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = visited[vx][vy] + 1
    
    return answer