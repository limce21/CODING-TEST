import sys
from collections import deque

INF = int(1e9)

a, b = map(int, sys.stdin.readline().split())
queue = deque([])
queue.append((a, 1))
answer = INF

while queue:
  v, c = queue.popleft()
  if v == b:
    answer = min(answer, c)
  if v * 2 <= b:
    queue.append((v * 2, c + 1))
  if v * 10 + 1 <= b:
    queue.append((v * 10 + 1, c + 1))

if answer == INF:
  print(-1)
else:
  print(answer)
