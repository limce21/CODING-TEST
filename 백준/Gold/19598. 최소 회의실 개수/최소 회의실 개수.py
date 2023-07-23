import heapq
import sys

input = sys.stdin.readline

n = int(input())
data = []
for _ in range(n):
  data.append(list(map(int, input().split())))

heap = []
data.sort(key=lambda x: (x[0], x[1]))
heapq.heappush(heap, data[0][1])

for i in range(1, n):
  s, e = data[i]
  he = heapq.heappop(heap)
  if s >= he:
    heapq.heappush(heap, e)
  else:
    heapq.heappush(heap, he)
    heapq.heappush(heap, e)

print(len(heap))