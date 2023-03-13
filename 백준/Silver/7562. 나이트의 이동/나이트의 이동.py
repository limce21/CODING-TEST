import sys
from collections import deque


def bfs(x, y, dest_x, dest_y):
  queue = deque()
  queue.append((x, y))
  while queue:
    x, y = queue.popleft()
    for i in range(8):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= l or ny < 0 or ny >= l:
        continue
      if graph[nx][ny] >= 1:
        continue
      if graph[nx][ny] == 0:
        graph[nx][ny] += graph[x][y] + 1
        queue.append((nx, ny))
  return graph[dest_x][dest_y]


t = int(sys.stdin.readline().rstrip())
dx = [2, 2, 1, 1, -1, -1, -2, -2]
dy = [1, -1, 2, -2, 2, -2, 1, -1]

for _ in range(t):
  l = int(sys.stdin.readline().rstrip())
  graph = [[0] * l for _ in range(l)]
  now_x, now_y = map(int, sys.stdin.readline().rstrip().split())
  graph[now_x][now_y] = 1
  dest_x, dest_y = map(int, sys.stdin.readline().rstrip().split())
  print(bfs(now_x, now_y, dest_x, dest_y)-1)
