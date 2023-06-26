import sys
from itertools import combinations
input = sys.stdin.readline

def dfs(x, y, depth, value):
  global answer
  if depth == 4:
    answer = max(value, answer)
    return

  for i in range(4):
    nx = dx[i] + x
    ny = dy[i] + y
    if nx < 0 or nx >= n or ny < 0 or ny >= m:
      continue
    if visited[nx][ny]:
      continue
    if not visited[nx][ny]:
      visited[nx][ny] = True
      dfs(nx, ny, depth + 1, value + data[nx][ny])
      visited[nx][ny] = False
  

n,m = map(int, input().split())
answer = 0
data = []
dx = [0,0,-1,1]
dy = [-1,1,0,0]
visited = [[False] * m for _ in range(n)]

for _ in range(n):
  data.append(list(map(int, input().split())))

answer = 0

for x in range(n):
  for y in range(m):
    visited[x][y] = True
    dfs(x,y, 1, data[x][y])
    visited[x][y] = False

for x in range(n):
  for y in range(m):
    combs = []
    for k in range(4):
      nx = dx[k] + x
      ny = dy[k] + y
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      combs.append(data[nx][ny])
    if len(combs) >= 3:
      result = list(combinations(combs, 3))
      result = max(list(map(lambda x: sum(x), result)))
      answer = max(answer, result + data[x][y])
      
print(answer)