import sys
from bisect import bisect_left, bisect_right

def count_by_range(a, left_value, right_value):
  left_index = bisect_left(a, left_value)
  right_index = bisect_right(a, right_value)
  return right_index, left_index

n, m = map(int, sys.stdin.readline().rstrip().split())
data = []
for _ in range(m):
  data.append(int(sys.stdin.readline().rstrip()))

data.sort()
result = []
for i in data:
  count = 0
  right_index, left_index = count_by_range(data, i, i)
  equal_count = right_index - left_index
  for j in range(0, m - right_index + equal_count):
    if count < n:
      count += 1
  result.append((i , (count) * i))

result.sort(key=lambda x : x[1], reverse=True)

price, total = result[0]
print(price, total)