import sys
from collections import deque


def bfs():
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= m or ny < 0 or ny >= n:
        continue
      if graph[nx][ny] >= 1 or graph[nx][ny] == -1:
        continue
      if graph[nx][ny] == 0:
        graph[nx][ny] = graph[x][y] + 1
        queue.append((nx, ny))


n, m = map(int, sys.stdin.readline().rstrip().split())
graph = []
for i in range(m):
  graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

queue = deque()

for i in range(m):
  for j in range(n):
    if graph[i][j] == 1:
      queue.append((i, j))

bfs()

if any(0 in l for l in graph):
  result = -1
else:
  max_value = max(map(max, graph))
  result = max_value - 1

print(result)
