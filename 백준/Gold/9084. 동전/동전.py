import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
  n = int(input())
  coins = list(map(int, input().split()))
  m = int(input())
  dp = [0] * (m+1)
  dp[0] = 1
  for i in range(n):
    for j in range(coins[i], m+1):
      dp[j] = dp[j] + dp[j-coins[i]]
  print(dp[m])