import sys


def count_candy():
  global max_cnt
  for i in range(n):
    cnt = 1
    for j in range(1, n):
      if graph[i][j] == graph[i][j - 1]:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
      else:
        cnt = 1
    cnt = 1
    for j in range(1, n):
      if graph[j][i] == graph[j - 1][i]:
        cnt += 1
        max_cnt = max(max_cnt, cnt)
      else:
        cnt = 1


n = int(sys.stdin.readline())
max_cnt = 0
graph = []

for _ in range(n):
  graph.append(list(sys.stdin.readline().rstrip()))

result = 0
for i in range(n):
  for j in range(n):
    if i + 1 < n:
      graph[i][j], graph[i + 1][j] = graph[i + 1][j], graph[i][j]
      count_candy()
      graph[i][j], graph[i + 1][j] = graph[i + 1][j], graph[i][j]
    if j + 1 < n:
      graph[i][j], graph[i][j + 1] = graph[i][j + 1], graph[i][j]
      count_candy()
      graph[i][j], graph[i][j + 1] = graph[i][j + 1], graph[i][j]

print(max_cnt)
