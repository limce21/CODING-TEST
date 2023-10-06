import sys
from collections import deque

INF = int(1e9)

input = sys.stdin.readline


def bfs(v):
  visited[v] = True
  queue = deque([])
  queue.append(v)
  while queue:
    x = queue.popleft()
    for i in range(2):
      nv = x + df[i]
      if 1 <= nv <= f and not visited[nv]:
        visited[nv] = True
        count[nv] = count[x] + 1
        queue.append(nv)

  return count[g]


f, s, g, u, d = map(int, input().split())
visited = [False] * (f + 1)
count = [0] * (f + 1)
df = [u, -d]
if s == g:
  print(0)
else:
  answer = bfs(s)
  
  if answer == 0:
    print("use the stairs")
  else:
    print(answer)
