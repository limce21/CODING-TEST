import sys
from collections import deque

input = sys.stdin.readline

def bfs(x, y):
  queue = deque([])
  queue.append((x, y))
  visited[x][y] = True
  cnt = 0
  while queue:
    cnt += 1
    vx, vy = queue.popleft()
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1 and not visited[nx][ny]:
        queue.append((nx, ny))
        visited[nx][ny] = True
  return cnt

n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(k):
  r, c = map(int, input().split())
  graph[r-1][c-1] = 1

answer = 0

for i in range(n):
  for j in range(m):
    if not visited[i][j] and graph[i][j] == 1:
      answer = max(answer, bfs(i, j))

print(answer)