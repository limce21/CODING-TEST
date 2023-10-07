import sys
from collections import deque

INF = int(1e9)


def bfs(x, y):
  queue = deque([])
  visited[0][x][y] = True
  queue.append((x, y, 0, 0))
  while queue:
    vx, vy, h_cnt, move_cnt = queue.popleft()
    if vx == w - 1 and vy == h - 1:
      global answer
      answer = min(answer, move_cnt)
    if h_cnt < k:
      for i in range(8):
        nx = vx + dh[i][0]
        ny = vy + dh[i][1]
        if 0 <= nx < w and 0 <= ny < h and graph[nx][
            ny] == 0 and not visited[h_cnt+1][nx][ny]:
          visited[h_cnt+1][nx][ny] = True
          queue.append((nx, ny, h_cnt + 1, move_cnt + 1))
    for i in range(4):
      nx = vx + dm[i][0]
      ny = vy + dm[i][1]
      if 0 <= nx < w and 0 <= ny < h and graph[nx][
          ny] == 0 and not visited[h_cnt][nx][ny]:
        visited[h_cnt][nx][ny] = True
        queue.append((nx, ny, h_cnt, move_cnt + 1))


input = sys.stdin.readline

k = int(input())
h, w = map(int, input().split())
graph = []
for _ in range(w):
  graph.append(list(map(int, input().split())))

dm = [(0, 1), (0, -1), (1, 0), (-1, 0)]
dh = [(1, 2), (1, -2), (-1, 2), (-1, -2), (2, 1), (2, -1), (-2, 1), (-2, -1)]
answer = INF
visited = [[[False] * h for _ in range(w)] for _ in range(k+1)]

bfs(0, 0)
if answer == INF:
  print(-1)
else:
  print(answer)
