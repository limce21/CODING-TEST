import sys

n = int(sys.stdin.readline().rstrip())
data = [0]
dp = [0] * (n + 1)

for _ in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

if n >= 1:
  dp[1] = data[1]
if n>= 2:
  dp[2] = data[1] + data[2]

for i in range(3, n + 1):
  dp[i] = dp[i-3] + data[i-1] + data[i]
  if i > 2:
    dp[i] = max(dp[i], dp[i - 2] + data[i])

print(dp[n])
