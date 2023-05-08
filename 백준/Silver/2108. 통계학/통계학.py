import sys
from collections import Counter

input = sys.stdin.readline
n = int(input())
data = []

for _ in range(n):
  data.append(int(input()))

sorted_data = sorted(data)
counter = list(Counter(data).items())
counter.sort(key=lambda x: (-x[1], x[0]))

print(round(sum(data)/n))
print(sorted_data[n//2])
if n >= 2 and counter[0][1] == counter[1][1]:
  print(counter[1][0])
else:
  print(counter[0][0])

print(max(data) - min(data))