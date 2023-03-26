import sys
import heapq

INF = int(1e9)
input = sys.stdin.readline

n, k = map(int, input().split())
distance = [INF] * (100001)


def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  distance[start] = 0
  while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
      continue
    dir = [(1, 1), (-1, 1), (now, 0)]
    for i in dir:
      cost = dist + i[1]
      if 0 <= now + i[0] < 100001 and cost < distance[now + i[0]]:
        distance[now + i[0]] = cost
        heapq.heappush(q, (cost, now + i[0]))


dijkstra(n)
print(distance[k])
