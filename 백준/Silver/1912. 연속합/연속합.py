import sys

n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().rstrip().split()))

for i in range(1, n):
  data[i] = max(data[i], data[i - 1] + data[i])

print(max(data))