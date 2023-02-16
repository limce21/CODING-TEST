import sys

sys.setrecursionlimit(10**6)


def dfs(graph, v, visited):
  global dict_data
  visited[v] = True
  for i in graph[v]:
    if not visited[i]:
      dict_data[i] = v
      dfs(graph, i, visited)


n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
for _ in range(n - 1):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  graph[a].append(b)
  graph[b].append(a)

dict_data = dict()
dfs(graph, 1, visited)
data = sorted(dict_data.items(), key=lambda x: x[0])

for i in data:
  print(i[1])
