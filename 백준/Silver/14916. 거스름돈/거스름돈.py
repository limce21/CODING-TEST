import sys

n = int(sys.stdin.readline().rstrip())
dp = [100001] * (n + 1)
dp[0] = 0

for i in range(2, n + 1):
  if i >= 2 and dp[i - 2] != 100001:
    dp[i] = dp[i - 2] + 1
  if i >= 5 and dp[i - 5] != 100001:
    dp[i] = min(dp[i], dp[i - 5] + 1)

if dp[n] == 100001:
  print(-1)
else:
  print(dp[n])
