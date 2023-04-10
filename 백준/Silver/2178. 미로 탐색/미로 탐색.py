import sys
from collections import deque


def bfs(x, y):
  queue = deque([])
  queue.append((x, y))
  visited[x][y] = True
  while queue:
    vx, vy = queue.popleft()
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 0:
        continue
      if not visited[nx][ny]:
        visited[nx][ny] = True
        graph[nx][ny] = graph[vx][vy] + 1
        queue.append((nx, ny))

  return graph[n - 1][m - 1]


n, m = map(int, sys.stdin.readline().rstrip().split())
graph = []
visited = [[False] * m for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(n):
  arr = list(sys.stdin.readline().rstrip())
  graph.append(list(map(int, arr)))

print(bfs(0, 0))
