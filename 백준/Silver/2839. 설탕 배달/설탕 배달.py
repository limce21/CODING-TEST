import sys

n = int(sys.stdin.readline().rstrip())
dp = [5001] * (5001)
dp[3] = 1
dp[5] = 1

for i in range(3, n + 1):
  dp[i] = min(dp[i], dp[i - 3]  + 1)
  if i >= 5:
    dp[i] = min(dp[i], dp[i - 5] + 1)

if dp[n] == 5001:
  print(-1)
else:
  print(dp[n])
