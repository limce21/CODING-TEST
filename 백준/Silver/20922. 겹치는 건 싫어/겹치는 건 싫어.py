import sys
from collections import deque
import heapq

input = sys.stdin.readline

n, k = map(int, input().split())
data = list(map(int, input().split()))
queue = deque([])

end = 0
cnt = [0] * (100001)
answer = 0
max_cnt = 0
heap = []
for start in data:
  while end < n:
    if cnt[data[end]] + 1 > k:
      break
    cnt[data[end]] += 1
    queue.append(data[end])
    end += 1
  answer = max(answer, len(queue))
  v = queue.popleft()
  cnt[v] -= 1

print(answer)
