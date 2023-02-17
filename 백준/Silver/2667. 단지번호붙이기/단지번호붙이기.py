import sys

sys.setrecursionlimit(1000)


def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if (0 <= nx < n) and (0 <= ny < n):
      if graph[nx][ny] == 1:
        graph[nx][ny] = 0
        home_list.append((nx, ny))
        dfs(nx, ny)


n = int(sys.stdin.readline().rstrip())
graph = []
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(n):
  graph.append(list(map(int, list(sys.stdin.readline().rstrip()))))

result = 0
num_list = []
for i in range(n):
  for j in range(n):
    if graph[i][j] == 1:
      home_list = [(i, j)]
      graph[i][j] = 0
      dfs(i, j)
      result += 1
      num_list.append(len(home_list))

print(result)
num_list.sort()
for i in num_list:
  print(i)
