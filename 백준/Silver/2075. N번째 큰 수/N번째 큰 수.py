import sys
import heapq

n = int(sys.stdin.readline().rstrip())

h = []

result = []
for _ in range(n):
  arr = list(map(int, sys.stdin.readline().rstrip().split()))
  heapq.heappush(h, arr[0])
  for i in range(1, len(arr)):
    x = heapq.heappop(h)
    if arr[i] > x:
      heapq.heappush(h, arr[i])
    else:
      heapq.heappush(h, x)

for i in range(n):
  result.append(heapq.heappop(h))

print(result[0])
