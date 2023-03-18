import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
data = []
for i in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

data.sort(reverse=True)

result = 0
for money in data:
  if k >= money:
    result += k // money
    k %= money
print(result)