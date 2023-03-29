import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())
data = []

for _ in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

print(round(sum(data) / n))

data_sort = sorted(data)
print(data_sort[n // 2])

counter = Counter(data)
counter = list(counter.items())
counter.sort(key=lambda x: (-x[1], x[0]))
if len(counter) >= 2 and counter[0][1] == counter[1][1]:
  print(counter[1][0])
else:
  print(counter[0][0])

print(max(data) - min(data))
