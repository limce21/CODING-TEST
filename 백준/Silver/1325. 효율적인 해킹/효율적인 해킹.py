import sys
from collections import deque


def bfs(graph, start, visited):
  queue = deque([start])
  visited[start] = True
  count = 0
  while queue:
    count += 1
    v = queue.popleft()
    for i in graph[v]:
      if not visited[i]:
        visited[i] = True
        queue.append(i)
  return count


n, m = map(int, sys.stdin.readline().rstrip().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  graph[b].append(a)

data = []
for i in range(1, n + 1):
  visited = [False] * (n + 1)
  data.append((i, bfs(graph, i, visited) - 1))

data = sorted(data, key=lambda x: x[1], reverse=True)
max_value = data[0][1]
for i in data:
  if i[1] == max_value:
    print(i[0], end=' ')
  else:
    break
