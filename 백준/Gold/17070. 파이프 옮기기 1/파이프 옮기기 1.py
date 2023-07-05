import sys

input = sys.stdin.readline

def dfs(x, y, state):
  if x == n-1 and y == n-1:
    global answer
    answer += 1
    return
  for i in pipe[state]:
    nx = x + i[0]
    ny = y + i[1]
    if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == 0:
      if i[2] == 2 and (graph[nx-1][ny] == 1 or graph[nx][ny-1] == 1):
        continue
      dfs(nx, ny, i[2])
    

pipe = [[(0,1,0), (1,1,2)],[(1,0,1), (1,1,2)],[(1,0,1), (0,1,0), (1,1,2)]
]

n = int(input())
graph = []
answer = 0
for _ in range(n):
  graph.append(list(map(int, input().split())))

if graph[n-1][n-1] != 1:
  dfs(0,1,0)
print(answer)
