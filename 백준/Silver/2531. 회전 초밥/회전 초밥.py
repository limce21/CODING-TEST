import sys
from collections import deque

input = sys.stdin.readline

n, d, k, c = map(int, input().split())
data = []
for _ in range(n):
  data.append(int(input()))

answer = 0
end = 0
eat_list = deque([])
for start in data:
  while len(eat_list) < k:
    eat_list.append(data[end % n])
    end += 1
  temp_set = set(eat_list)
  if c not in temp_set:
    answer = max(len(temp_set) + 1, answer)
  else:
    answer = max(len(temp_set), answer)
  eat_list.popleft()

print(answer)
