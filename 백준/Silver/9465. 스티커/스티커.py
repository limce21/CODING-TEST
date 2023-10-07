import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
  n = int(input())
  data = []
  dp = [[0] * (n + 2) for _ in range(2)]
  for i in range(2):
    data.append(list(map(int, input().split())))
  for i in range(2, n+2):
    for j in range(2):
      dp[j][i] = max(data[j][i-2] + dp[(j + 1) % 2][i - 2],
                     data[j][i-2] + dp[(j + 1) % 2][i - 1])

  print(max(max(dp[0]), max(dp[1])))

