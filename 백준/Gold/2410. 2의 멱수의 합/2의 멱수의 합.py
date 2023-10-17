import sys
INF = int(1e9)

input = sys.stdin.readline
n = int(input())
dp = [0] * (n+1)
dp[1] = 1
if n >= 2:
  dp[2] = 2
if n >= 3:
  for i in range(3, n+1):
    dp[i] = dp[i-1]
    if i % 2 == 0:
      dp[i] += dp[i // 2]
    else:
      dp[i] = dp[i-1]

print(dp[n]%INF)