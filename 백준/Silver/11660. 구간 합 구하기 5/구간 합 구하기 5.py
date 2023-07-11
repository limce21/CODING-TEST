import sys

input = sys.stdin.readline

n, m = map(int, input().split())
data = []

for _ in range(n):
  data.append(list(map(int, input().split())))

dp = [[0] * n for _ in range(n)]
row = 0
col = 0
for i in range(n):
  row += data[0][i]
  col += data[i][0]
  dp[0][i] = row
  dp[i][0] = col

for i in range(1, n):
  for j in range(1, n):
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + data[i][j]

answer = []
for i in range(m):
  x1, y1, x2, y2 = map(int, input().split())
  x1 -= 1
  y1 -= 1
  x2 -= 1
  y2 -= 1
  value = 0
  if x1 == x2 and y1 == y2:
    value = data[x1][y1]
  else:
    if x1 < 1 and y1 < 1:
      value = dp[x2][y2]
    elif x1 < 1 and y1 >= 1:
      value = dp[x2][y2] - dp[x2][y1 - 1]
    elif x1 >= 1 and y1 < 1:
      value = dp[x2][y2] - dp[x1 - 1][y2]
    else:
      value = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]
  answer.append(value)

for i in answer:
  print(i)
