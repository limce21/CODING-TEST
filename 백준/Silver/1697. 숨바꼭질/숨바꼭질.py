import sys
from collections import deque


def bfs(x):
  global k
  queue = deque([x])
  while queue:
    v = queue.popleft()
    if v == k:
      return graph[v]
    dx[2] = v
    for i in range(3):
      nx = v + dx[i]
      if nx < 0 or nx > (100000):
        continue
      if graph[nx] > 0:
        continue
      if graph[nx] == 0:
        graph[nx] = graph[v] + 1
        queue.append(nx)

n, k = map(int, sys.stdin.readline().rstrip().split())
graph = [0] * (100001)
dx = [-1, 1, n]

print(bfs(n))
