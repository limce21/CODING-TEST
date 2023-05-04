import sys

input = sys.stdin.readline

n = int(input())
triangle = []
for _ in range(n):
  triangle.append(list(map(int, input().split())))

dp = [[0] * (i + 1) for i in range(n)]
dp[0][0] = triangle[0][0]
for i in range(1, n):
  for j in range(i + 1):
    if j == 0:
      dp[i][j] = dp[i - 1][j] + triangle[i][j]
    elif j == i:
      dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
    else:
      dp[i][j] = triangle[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j])

print(max(dp[n - 1]))
