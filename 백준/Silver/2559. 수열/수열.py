import sys

n, k = map(int, sys.stdin.readline().split())
data = list(map(int, sys.stdin.readline().split()))
interval_sum = sum(data[:k])
result = [interval_sum]

for start in range(n - k):
  interval_sum = interval_sum - data[start] + data[start + k]
  result.append(interval_sum)

print(max(result))
