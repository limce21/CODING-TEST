import sys
from collections import deque


def bfs(x, y):
  queue = deque()
  queue.append((x, y))
  visited[x][y] = True
  while queue:
    vx, vy = queue.popleft()
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] != 0:
        queue.append((nx, ny))
        visited[nx][ny] = True
        graph[nx][ny] = graph[vx][vy] + 1


n, m = map(int, sys.stdin.readline().split())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
visited = [[False] * m for _ in range(n)]
graph = []
for _ in range(n):
  arr = list(sys.stdin.readline().rstrip())
  graph.append(list(map(int, arr)))

bfs(0, 0)
print(graph[n - 1][m - 1])
