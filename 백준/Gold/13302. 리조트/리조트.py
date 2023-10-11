import sys
INF = int(1e9)
input = sys.stdin.readline

n, m = map(int, input().split())
holidays = list(map(int, input().split()))

dp = [[INF] * (41) for _ in range(106)]
dp[0][0] = 0

for i in range(n+1):
  for j in range(39):
    if dp[i][j] == INF:
      continue
    result = dp[i][j]
    if i+1 in holidays:
      dp[i+1][j] = min(result, dp[i+1][j])
    if j >= 3:
      dp[i+1][j-3] = min(dp[i+1][j-3], result)
    dp[i+1][j] = min(result+10000, dp[i+1][j])
    for k in range(1, 4):
      dp[i+k][j+1] = min(result+25000, dp[i+k][j+1])
    for k in range(1, 6):
      dp[i+k][j+2] = min(result+37000, dp[i+k][j+2])

print(min(dp[n]))