import sys

INF = int(1e9)
input = sys.stdin.readline

n, k = map(int, input().split())
data = [0] + list(map(int, input().split()))
dp = [0] * (n + 1)

for i in range(1, n + 1):
  if i > 1 and dp[i] == 0:
    continue
  for j in range(i + 1, n + 1):
    val = (j - i) * (1 + abs(data[i] - data[j]))
    if val <= k:
      if dp[j] == 0:
        dp[j] = dp[i] + val
      else:
        dp[j] = min(dp[j], dp[i] + val)

if dp[n] == 0:
  print("NO")
else:
  print("YES")
