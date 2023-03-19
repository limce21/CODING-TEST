import sys
import heapq

n = int(sys.stdin.readline().rstrip())
h = []
for _ in range(n):
  x = int(sys.stdin.readline().rstrip())
  if x != 0:
    heapq.heappush(h, (abs(x), x))
  else:
    if len(h) == 0:
      print(0)
    else:
      print(heapq.heappop(h)[1])
  