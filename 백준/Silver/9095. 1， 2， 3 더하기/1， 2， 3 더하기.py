import sys

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
  n = int(sys.stdin.readline().rstrip())
  dp = [0] * (11)
  dp[1] = 1
  dp[2] = 1
  dp[3] = 1
  for i in range(1, n + 1):
    dp[i] += dp[i - 1]
    if i > 2:
      dp[i] += dp[i - 2]
    if i > 3:
      dp[i] += dp[i - 3]
  print(dp[n])

