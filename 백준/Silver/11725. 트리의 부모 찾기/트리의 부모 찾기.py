import sys
from collections import deque


def bfs():
  queue = deque()
  queue.append(1)
  visited[1] = True
  while queue:
    value = queue.popleft()
    for i in graph[value]:
      if not visited[i]:
        data[i] = value
        queue.append(i)
        visited[i] = True


n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]
data = [0] * (n + 1)

for _ in range(n - 1):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  graph[a].append(b)
  graph[b].append(a)

visited = [False] * (n + 1)
bfs()
for i in range(2, n + 1):
  print(data[i])