import sys
import heapq
INF = int(1e9)

input = sys.stdin.readline

def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  distance[start] = 0
  while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
      continue
    for i in graph[now]:
      cost = dist + i[1]
      if cost <= m and cost < distance[i[0]]:
        distance[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))
  
  cnt = 0
  for i in range(1, n+1):
    if distance[i] != INF:
      cnt += items[i]
  return cnt

n, m, r = map(int, input().split())
answer = 0
items = [0] + list(map(int, input().split()))
graph = [[] for _ in range(n+1)]

for _ in range(r):
  a, b, l = map(int, input().split())
  graph[a].append((b,l))
  graph[b].append((a,l))

for i in range(1, n+1):
  distance = [INF] * (n+1)
  answer = max(answer, dijkstra(i))

print(answer)