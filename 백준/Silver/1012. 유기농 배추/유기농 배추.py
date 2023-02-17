import sys

sys.setrecursionlimit(2500)


def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if (0 <= nx < n) and (0 <= ny < m):
      if graph[nx][ny] == 1:
        graph[nx][ny] = 0
        dfs(nx, ny)


t = int(sys.stdin.readline().rstrip())
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(t):
  m, n, k = map(int, sys.stdin.readline().rstrip().split())
  graph = [[0] * m for _ in range(n)]
  result = 0
  for _ in range(k):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[y][x] = 1
  for i in range(n):
    for j in range(m):
      if graph[i][j] == 1:
        dfs(i, j)
        result += 1
  print(result)
