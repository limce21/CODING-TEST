import sys
from collections import deque

input = sys.stdin.readline


def bfs():
  global m, n, h
  while queue:
    z, x, y = queue.popleft()
    for i in range(6):
      nz = z + dz[i]
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nz < h and 0 <= nx < n and 0 <= ny < m and graph[nz][nx][ny] == 0:
        queue.append((nz, nx, ny))
        graph[nz][nx][ny] = graph[z][x][y] + 1



m, n, h = map(int, input().split())
dx = [0, 0, 1, -1, 0, 0]
dy = [0, 0, 0, 0, 1, -1]
dz = [1, -1, 0, 0, 0, 0]

graph = [[] for _ in range(h)]
for k in range(h):
  for i in range(n):
    graph[k].append(list(map(int, input().split())))

queue = deque()

for k in range(h):
  for i in range(n):
    for j in range(m):
      if graph[k][i][j] == 1:
        queue.append((k, i, j))

bfs()

result = 0
flag = False
for k in range(h):
  for i in range(n):
    for j in range(m):
      if graph[k][i][j] == 0:
        flag = True
        break
      else:
        result = max(result, graph[k][i][j])

if flag:
  print(-1)
else:
  print(result - 1)
