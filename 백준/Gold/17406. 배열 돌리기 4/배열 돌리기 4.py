import sys
import copy

input = sys.stdin.readline
INF = int(1e9)


def rotation(l, r):
  global graph
  lx, ly = l
  rx, ry = r

  tmp = graph[lx][ly]
  for i in range(lx, rx):
    graph[i][ly] = graph[i + 1][ly]
  for i in range(ly, ry):
    graph[rx][i] = graph[rx][i + 1]
  for i in range(rx, lx, -1):
    graph[i][ry] = graph[i - 1][ry]
  for i in range(ry, ly + 1, -1):
    graph[lx][i] = graph[lx][i - 1]
  graph[lx][ly + 1] = tmp

  lx, rx = lx + 1, rx - 1
  ly, ry = ly + 1, ry - 1
  if lx == rx and ly == ry:
    return
  else:
    rotation((lx, ly), (rx, ry))


def calculate(cnt, visited):
  global graph, answer
  if cnt == k:
    for i in graph:
      answer = min(answer, sum(i))
    return

  for i in range(k):
    if not visited[i]:
      tmp = copy.deepcopy(graph)
      r, c, s = k_list[i]
      lx, ly = r - s - 1, c - s - 1
      rx, ry = r + s - 1, c + s - 1
      visited[i] = True
      rotation((lx, ly), (rx, ry))
      calculate(cnt + 1, visited)
      graph = tmp
      visited[i] = False


n, m, k = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))

k_list = []

for _ in range(k):
  r, c, s = map(int, input().split())
  k_list.append((r, c, s))

answer = INF
visited = [False] * (k)
calculate(0, visited)

print(answer)
