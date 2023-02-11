import sys

n, k = map(int, sys.stdin.readline().rstrip().split())

data = []

for _ in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

data.sort(reverse=True)

result = 0

for i in data:
  result += k // i
  k %= i

print(result)