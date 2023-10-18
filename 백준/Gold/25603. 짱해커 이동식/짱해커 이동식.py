import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())
cost = list(map(int, input().split()))

s = 0
min_cost = cost[0]
ans = cost[0]
for i in range(s, s + k):
  if cost[i] <= min_cost:
    min_idx = i
    min_cost = cost[i]
    ans = min_cost
s = min_idx + 1

while s + k <= n:
  q = deque()
  i = s
  min_window = 0
  for j in range(i, n):
    if cost[j] <= ans:
      s = j + 1
      break
    else:
      q.append(cost[j])
      if min_window == 0:
        min_window = cost[j]
        min_window_idx = j
      else:
        if cost[j] < min_window:
          min_window = cost[j]
          min_window_idx = j
      if len(q) >= k:
        s = min_window_idx + 1
        ans = min_window
        break

print(ans)
