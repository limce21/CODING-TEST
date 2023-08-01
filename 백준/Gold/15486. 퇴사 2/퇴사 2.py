import sys

input = sys.stdin.readline

n = int(input())
data = [[0, 0]]
dp = [0] * (n + 2)
for _ in range(n):
  data.append(list(map(int, input().split())))

for i in range(1, n + 1):
  t, p = data[i]
  dp[i] = max(dp[i], dp[i - 1])  # 패스한 경우
  if t == 1:  # t가 1이면 그날 p를 받을 수 있다.
    dp[i] += p
  else:
    if i + t > n + 1:
      continue
    dp[i + t] = max(dp[i + t], dp[i] + p)

print(max(dp))
