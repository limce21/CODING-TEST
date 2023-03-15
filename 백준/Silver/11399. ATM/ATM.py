import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))

data.sort()
result = 0
for i in range(n):
  result += data[i] * (n - i)

print(result)
