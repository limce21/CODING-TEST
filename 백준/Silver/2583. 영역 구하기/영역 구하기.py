import sys
from collections import deque


def bfs(x, y):
  queue = deque()
  queue.append((x, y))
  visited[x][y] = True
  result = 0
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= m or ny < 0 or ny >= n:
        continue
      if visited[nx][ny]:
        continue
      if not visited[nx][ny]:
        graph[nx][ny] = graph[x][y] + 1
        result += 1
        visited[nx][ny] = True
        queue.append((nx, ny))
  return result


m, n, k = map(int, sys.stdin.readline().rstrip().split())
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
graph = [[0] * (n) for _ in range(m)]
visited = [[False] * (n) for _ in range(m)]

for _ in range(k):
  lx, ly, rx, ry = map(int, sys.stdin.readline().rstrip().split())
  for i in range(ly, ry - ly + ly):
    for j in range(lx, rx - lx + lx):
      graph[i][j] = 1
      visited[i][j] = True

result = 0
answer = []
for i in range(m):
  for j in range(n):
    if not visited[i][j]:
      answer.append(bfs(i, j) + 1)
      result += 1

answer.sort()
print(result)
for i in answer:
  print(i, end=' ')
