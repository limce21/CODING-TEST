import sys
from collections import deque
INF = int(1e9)

input = sys.stdin.readline

def make_area(x, y, area):
  area_lst[x][y] = area
  queue = deque([])
  queue.append((x, y))
  while queue:
    vx, vy = queue.popleft()
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 1 and area_lst[nx][ny] == 0:
        area_lst[nx][ny] = area
        queue.append((nx, ny))

def bfs(x, y):
  an = area_lst[x][y]
  queue = deque([])
  queue.append((x, y, 0))
  visited[x][y] = True
  while queue:
    vx, vy, cnt = queue.popleft()
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if 0 <= nx < n and 0 <= ny < n and area_lst[nx][ny] != an and not visited[nx][ny]:
        if area_lst[nx][ny] != 0:
          global answer
          answer = min(answer, cnt)
          return
        else:
          visited[nx][ny] = True
          queue.append((nx, ny, cnt+1))
          


n = int(input())
answer = INF
graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
area_lst = [[0] * (n) for _ in range(n)]

area_num = 1
for i in range(n):
  for j in range(n):
    if graph[i][j] == 1 and not area_lst[i][j]:
      make_area(i, j, area_num)
      area_num += 1

for x in range(n):
  for y in range(n):
    if graph[x][y] == 1:
      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 0:
          visited = [[False] * n for _ in range(n)]
          bfs(x, y)

print(answer)