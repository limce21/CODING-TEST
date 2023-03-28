import sys
import heapq

input = sys.stdin.readline

data = []
n = int(input())

for _ in range(n):
  s, e = map(int, input().split())
  data.append((s, e))

data.sort()
q = []
heapq.heappush(q, data[0][1])
for i in range(1, n):
  if data[i][0] < q[0]:
    heapq.heappush(q, data[i][1])
  else:
    heapq.heappop(q)
    heapq.heappush(q, data[i][1])

print(len(q))