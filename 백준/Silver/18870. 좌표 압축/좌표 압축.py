import sys
from bisect import bisect_left

def count_by_range(a, left_value):
  left_index = bisect_left(a, left_value)
  return left_index

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
data_set = set(data)
sorted_data = sorted(list(data_set))

result = []
for x in data:
  count = count_by_range(sorted_data, x)
  result.append(count)

for i in result:
  print(i, end=' ')