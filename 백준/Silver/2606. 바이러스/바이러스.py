import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
  queue = deque()
  queue.append(start)
  visited[start] = True
  answer = 0

  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if not visited[i]:
        visited[i] = True
        answer += 1
        queue.append(i)

  return answer


n = int(input())
t = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(t):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

print(bfs(1))
