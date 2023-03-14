import sys

sys.setrecursionlimit(15000)


def dfs(x, y, k):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if (0 <= nx < n) and (
        0 <= ny < n) and visited[nx][ny] == False and graph[nx][ny] > k:
      visited[nx][ny] = True
      dfs(nx, ny, k)
  return True
  return False


n = int(sys.stdin.readline().rstrip())
graph = []
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(n):
  graph.append(list(map(int, sys.stdin.readline().rstrip().split())))

max_value = max(map(max, graph))

result = 1
for k in range(1, max_value + 1):
  sub_result = 0
  visited = [[False] * n for _ in range(n)]
  for i in range(n):
    for j in range(n):
      if visited[i][j] == False and graph[i][j] > k:
        visited[i][j] = True
        dfs(i, j, k)
        sub_result += 1
  result = max(sub_result, result)

print(result)
