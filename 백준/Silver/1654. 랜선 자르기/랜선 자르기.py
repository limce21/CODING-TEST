import sys

k, n = map(int, sys.stdin.readline().rstrip().split())
data = []
for _ in range(k):
  data.append(int(sys.stdin.readline().rstrip()))

start = 1
end = max(data)

while (start <= end):
  total = 0
  mid = (start + end) // 2
  for x in data:
    total += x // mid
  if total < n:
    end = mid - 1
  else:
    result = mid
    start = mid + 1

print(result)
