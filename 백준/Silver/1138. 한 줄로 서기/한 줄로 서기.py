import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))[::-1]
result = []
for i in data:
  result.insert(i, n)
  n -= 1
print(*result)