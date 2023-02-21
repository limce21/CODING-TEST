import sys
import math

n = int(sys.stdin.readline().rstrip())
array = [True for _ in range(n + 1)]

for i in range(2, int(math.sqrt(n)) + 1):
  if array[i] == True:
    j = 2
    while i * j <= n:
      array[i * j] = False
      j += 1

data = []
for i in range(2, n + 1):
  if array[i] == True:
    data.append(i)

count = 0
interval_sum = 0
end = 0
for start in range(len(data)):
  while interval_sum < n and end < len(data):
    interval_sum += data[end]
    end += 1
  if interval_sum == n:
    count += 1
  interval_sum -= data[start]

print(count)