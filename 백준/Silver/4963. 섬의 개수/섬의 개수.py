import sys

sys.setrecursionlimit(100000)

dx = [0, 0, 1, -1, 1, -1, 1, -1]
dy = [1, -1, 0, 0, 1, -1, -1, 1]


def dfs(x, y):
  global w, h
  if x <= -1 or x >= h or y <= -1 or y >= w:
    return False
  if graph[x][y] == 1:
    graph[x][y] = 0
    for i in range(8):
      dfs(x + dx[i], y + dy[i])
    return True
  return False


while 1:
  w, h = map(int, sys.stdin.readline().rstrip().split())
  if w == 0 and h == 0:
    break
  graph = []
  result = 0
  for _ in range(h):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))
  for i in range(h):
    for j in range(w):
      if dfs(i, j) == True:
        result += 1
  print(result)
