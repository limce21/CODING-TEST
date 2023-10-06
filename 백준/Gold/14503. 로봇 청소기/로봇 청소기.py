import sys

input = sys.stdin.readline

dir_d = {0: (-1, 0), 1: (0, 1), 2: (1, 0), 3: (0, -1)}


def dfs(x, y, d, cnt):
  check = False
  for i in range(4):
    nx = x + dir_d[i][0]
    ny = y + dir_d[i][1]
    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
      check = True
      break
  if check:
    for i in range(1,5):
      nd = (d - i + 4) % 4
      nx = x + dir_d[nd][0]
      ny = y + dir_d[nd][1]
      if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
        graph[nx][ny] = 2
        dfs(nx, ny, nd, cnt + 1)
  else:
    nx = x - dir_d[d][0]
    ny = y - dir_d[d][1]
    if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 1:
      dfs(nx, ny, d, cnt)
    else:
      answer = 0
      for i in graph:
        answer += i.count(2)
      print(answer)
      exit(0)


n, m = map(int, input().split())
r, c, d = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))
graph[r][c] = 2
dfs(r, c, d, 1)
