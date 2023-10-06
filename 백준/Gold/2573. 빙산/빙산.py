import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(x, y, visited):
  visited[x][y] = True
  for i in range(4):
    nx = x + d[i][0]
    ny = y + d[i][1]
    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 0 and not visited[nx][
        ny]:
      visited[nx][ny] = True
      dfs(nx, ny, visited)


def melt():
  cnt = 0
  while True:
    cnt += 1
    minus_lst = [0] * len(icebergs)
    zero_cnt = 0
    for i in range(len(icebergs)):
      x, y = icebergs[i]
      if graph[x][y] == 0:
        zero_cnt += 1
        continue
      for j in range(4):
        nx = x + d[j][0]
        ny = y + d[j][1]
        if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
          minus_lst[i] += 1
    if zero_cnt == len(icebergs):
      print(0)
      exit()

    for i in range(len(icebergs)):
      x, y = icebergs[i]
      if graph[x][y] == 0:
        continue
      graph[x][y] -= minus_lst[i]
      if graph[x][y] < 0:
        graph[x][y] = 0

    visited = [[False] * m for _ in range(n)]
    result = 0
    for i in range(n):
      for j in range(m):
        if not visited[i][j] and graph[i][j] != 0:
          dfs(i, j, visited)
          result += 1
    if result >= 2:
      print(cnt)
      exit()


n, m = map(int, input().split())
d = [(0, -1), (0, 1), (-1, 0), (1, 0)]
graph = []
icebergs = []

for i in range(n):
  arr = list(map(int, input().split()))
  for j in range(m):
    if arr[j] != 0:
      icebergs.append((i, j))
  graph.append(arr)

melt()
