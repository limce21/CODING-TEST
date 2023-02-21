import sys

n, s = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))

interval_sum = 0
end = 0
count = []
result = 0

for start in range(n):
  while end < n and interval_sum < s:
    interval_sum += data[end]
    end += 1
  if interval_sum >= s:
    count.append(end - start)
  interval_sum -= data[start]

if len(count) == 0:
  print(0)
else:
  print(min(count))