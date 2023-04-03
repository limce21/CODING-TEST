import sys

input = sys.stdin.readline

n, m, b = map(int, input().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

height = 0
answer = sys.maxsize
for floor in range(257):
  max_target, min_target = 0, 0

  for i in range(n):
    for j in range(m):
      if graph[i][j] >= floor:
        max_target += graph[i][j] - floor
      else:
        min_target += floor - graph[i][j]

  if max_target + b >= min_target:
    if min_target + 2 * max_target <= answer:
      answer = min_target + 2 * max_target
      height = floor

print(answer, height)