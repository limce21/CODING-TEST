import sys

INF = int(1e9)

input = sys.stdin.readline

n = int(input())
graph = [[INF] * (n + 1) for _ in range(n + 1)]


for i in range(1, n + 1):
  data = list(map(int, input().split()))
  for j in range(len(data)):
    if data[j] == 1:
      graph[i][j + 1] = 1

for k in range(1, n + 1):
  for a in range(1, n + 1):
    for b in range(1, n + 1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, n + 1):
  for b in range(1, n + 1):
    if graph[a][b] >= INF:
      print(0, end=' ')
    else:
      print(1, end=' ')
  print()
