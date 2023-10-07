import sys
from collections import deque 

input = sys.stdin.readline


def bfs(x, y, visited):
  queue = deque([])
  queue.append((x, y))
  visited[x][y] = True
  while queue:
    vx, vy = queue.popleft()
    for i in range(4):
      nx = vx + d[i][0]
      ny = vy + d[i][1]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 0 and not visited[nx][
          ny]:
        visited[nx][ny] = True
        queue.append((nx, ny))


def melt():
  cnt = 0
  while icebergs:
    cnt += 1
    minus_lst = dict.fromkeys(icebergs, 0)
    for x, y in icebergs:
      for j in range(4):
        nx = x + d[j][0]
        ny = y + d[j][1]
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
          minus_lst[(x, y)] += 1

    remove_lst = []
    for x, y in icebergs:
      graph[x][y] -= minus_lst[(x, y)]
      if graph[x][y] <= 0:
        remove_lst.append((x, y))

    for x, y in remove_lst:
      graph[x][y] = 0
      icebergs.remove((x, y))

    visited = [[False] * m for _ in range(n)]
    result = 0

    for x, y in icebergs:
      if not visited[x][y] and graph[x][y] > 0:
        bfs(x, y, visited)
        result += 1

    if result >= 2:
      print(cnt)
      exit()

  print(0)


n, m = map(int, input().split())
d = [(0, -1), (0, 1), (-1, 0), (1, 0)]
graph = []
icebergs = set()

for i in range(n):
  arr = list(map(int, input().split()))
  for j in range(m):
    if arr[j] != 0:
      icebergs.add((i, j))
  graph.append(arr)

melt()
