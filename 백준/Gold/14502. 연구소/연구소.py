import sys
from collections import deque
import copy

def bfs():
  tmp = copy.deepcopy(graph)
  queue = deque([])

  for i in range(n):
    for j in range(m):
      if tmp[i][j] == 2:
        queue.append((i, j))

  while queue:
    i, j = queue.popleft()
    for k in range(4):
      ni = i + di[k]
      nj = j + dj[k]
      if ni < 0 or ni >= n or nj < 0 or nj >= m:
        continue
      if tmp[ni][nj] == 1:
        continue
      if tmp[ni][nj] == 0:
        tmp[ni][nj] = 2
        queue.append((ni, nj))

  global answer
  cnt = 0
  for i in range(n):
    cnt += tmp[i].count(0)
  answer = max(answer, cnt)

def make_wall(cnt):
  if cnt == 3:
    bfs()
    return
  for i in range(n):
    for j in range(m):
      if graph[i][j] == 0:
        graph[i][j] = 1
        make_wall(cnt + 1)
        graph[i][j] = 0

n, m = map(int, sys.stdin.readline().split())
graph = []
di = [0, 0, -1, 1]
dj = [-1, 1, 0, 0]

for _ in range(n):
  graph.append(list(map(int, sys.stdin.readline().split())))

answer = 0
make_wall(0)
print(answer)


