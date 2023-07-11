import sys

input = sys.stdin.readline
n = int(input())
data = [0]
dp = [0] * (n + 1)
answer = 0

for _ in range(n):
  data.append(int(input()))

dp[1] = data[1]
if n == 1:
  answer = dp[1]
elif n == 2:
  answer = data[1] + data[2]
else:
  dp[2] = data[1] + data[2]
  for i in range(3, n + 1):
    dp[i] = max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i],
                dp[i - 1])
  answer = dp[n]

print(answer)