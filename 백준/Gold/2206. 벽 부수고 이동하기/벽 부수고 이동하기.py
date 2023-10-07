import sys
from collections import deque

input = sys.stdin.readline

def bfs(x, y):
  queue = deque([])
  queue.append((x, y, 0))
  visited[0][x][y] = 1
  visited[1][x][y] = 1
  while queue:
    vx, vy, cnt = queue.popleft()
    for i in range(4):
      nx = vx + d[i][0]
      ny = vy + d[i][1]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0 and visited[cnt][nx][ny] == 0:
        visited[cnt][nx][ny] = visited[cnt][vx][vy] + 1
        queue.append((nx, ny, cnt))
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and cnt == 0:
        visited[1][nx][ny] = visited[0][vx][vy] + 1
        queue.append((nx, ny, 1))

  if visited[0][n-1][m-1] != 0 and visited[1][n-1][m-1] != 0:
    return min(visited[0][n-1][m-1], visited[1][n-1][m-1])
  if visited[0][n-1][m-1] == 0 and visited[1][n-1][m-1] != 0:
    return visited[1][n-1][m-1]
  if visited[0][n-1][m-1] != 0 and visited[1][n-1][m-1] == 0:
    return visited[0][n-1][m-1]
  if visited[0][n-1][m-1] == 0 and visited[1][n-1][m-1] == 0:
    return -1

n, m = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, list(input().rstrip()))))

visited = [[[0] * m for _ in range(n)] for _ in range(2)]
d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

answer = bfs(0, 0)
print(answer)

