import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
data = list(map(int, sys.stdin.readline().rstrip().split()))
end = 0
count = 0
interval_sum = 0

for start in range(n):
  while end < n and interval_sum < m:
    interval_sum += data[end]
    end += 1
  if interval_sum == m:
    count += 1
  interval_sum -= data[start]

print(count)