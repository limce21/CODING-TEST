import sys

INF = int(1e9)

input = sys.stdin.readline

c, n = map(int, input().split())
data = []
dp = [INF] * (c + 100)
dp[0] = 0

for _ in range(n):
  cost, cust = map(int, input().split())
  data.append((cost, cust))

for cost, cust in data:
  for i in range(cust, c + 100):
    dp[i] = min(dp[i - cust] + cost, dp[i])

print(min(dp[c:]))
