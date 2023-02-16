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
        queue.append(i)
        visited[i] = True
    result += 1


n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

visited = [False] * (n + 1)
graph = [[] for _ in range(n + 1)]

result = 0

for _ in range(m):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  graph[a].append(b)
  graph[b].append(a)

bfs(graph, 1, visited)
print(result - 1)
