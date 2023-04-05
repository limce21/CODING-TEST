import sys
from collections import deque

input = sys.stdin.readline


def bfs(start):
  queue = deque([])
  queue.append(start)
  visited[start] = True
  result = 1
  while queue:
    value = queue.popleft()
    for i in graph[value]:
      if not visited[i]:
        visited[i] = True
        queue.append(i)
        result += 1
  return result


n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
  a, b = map(int, input().split())
  graph[b].append(a)

answer = []
for i in range(1, n + 1):
  visited = [False] * (n + 1)
  answer.append((i, bfs(i)))

answer.sort(key=lambda x: (-x[1], x[0]))
max_value = answer[0][1]

for i in answer:
  if i[1] == max_value:
    print(i[0], end=" ")
  else:
    break