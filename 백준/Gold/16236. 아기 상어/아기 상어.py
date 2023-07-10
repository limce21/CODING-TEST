import sys
from collections import deque

input = sys.stdin.readline
shark_size = 2
answer = 0
graph = []
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

cx, cy = 0, 0

n = int(input())
for i in range(n):
  tmp = list(map(int, input().split()))
  graph.append(tmp)
  for j in range(n):
    if tmp[j] == 9:
      cx = i
      cy = j
      tmp[j] = 0


def bfs(x, y, px, py):
  global shark_size
  queue = deque([])
  queue.append([x, y])
  tmp = [[0] * n for _ in range(n)]

  while queue:
    vx, vy = queue.popleft()
    if vx == px and vy == py:
      break
    for i in range(4):
      nx = vx + dx[i]
      ny = vy + dy[i]
      if 0 <= nx < n and 0 <= ny < n and tmp[nx][ny] == 0:
        if graph[nx][ny] == 0 or graph[nx][ny] <= shark_size:
          tmp[nx][ny] = tmp[vx][vy] + 1
          queue.append((nx, ny))

  if tmp[px][py] == 0:
    return False, 0
  else:
    return True, tmp[px][py]


eat_cnt = 0
while True:
  case = []
  for i in range(n):
    for j in range(n):
      if graph[i][j] != 0 and graph[i][j] < shark_size:
        val, cnt = bfs(cx, cy, i, j)
        if val:
          case.append([cnt, i, j])
  if case:
    case.sort(key=lambda x: (x[0], x[1], x[2]))
    answer += case[0][0]
    eat_cnt += 1
    if eat_cnt == shark_size:
      shark_size += 1
      eat_cnt = 0
    cx = case[0][1]
    cy = case[0][2]
    graph[cx][cy] = 0
  else:
    break

print(answer)
