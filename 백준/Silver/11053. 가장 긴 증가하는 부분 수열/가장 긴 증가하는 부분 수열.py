import sys

n = int(sys.stdin.readline())
data = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [1] * n

for i in range(1, n):
  for j in range(0, i):
    if data[j] < data[i]:
      dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))