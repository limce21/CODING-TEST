import sys
from collections import deque


def bfs(graph, start, visited):
  global result
  queue = deque([start])
  visited[start] = True
  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if not visited[i]:
        visited[i] = True
        queue.append(i)
  result += 1


n, m = map(int, sys.stdin.readline().rstrip().split())
visited = [False] * (n + 1)
graph = [[] for _ in range(n + 1)]
result = 0

for _ in range(m):
  u, v = map(int, sys.stdin.readline().rstrip().split())
  graph[u].append(v)
  graph[v].append(u)

for i in range(1, n + 1):
  if not visited[i]:
    bfs(graph, i, visited)

print(result)