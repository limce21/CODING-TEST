import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < n and 0 <= ny < m:
      if graph[nx][ny] == 1:
        graph[nx][ny] = 0
        dfs(nx, ny)


t = int(input())
for _ in range(t):
  m, n, k = map(int, input().split())
  graph = [[0] * m for _ in range(n)]

  dx = [0, 0, 1, -1]
  dy = [1, -1, 0, 0]

  for _ in range(k):
    x, y = map(int, input().split())
    graph[y][x] = 1

  cnt = 0
  for i in range(n):
    for j in range(m):
      if graph[i][j] == 1:
        dfs(i, j)
        cnt += 1

  print(cnt)
