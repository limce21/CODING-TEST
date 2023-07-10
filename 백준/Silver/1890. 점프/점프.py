import sys

input = sys.stdin.readline

answer = 0

n = int(input())
graph = []
dp = [[0] * n for _ in range(n)]
for _ in range(n):
  graph.append(list(map(int, input().split())))

dp[0][0] = 1
for i in range(n):
  for j in range(n):
    if i == n - 1 and j == n - 1:
      break
    if dp[i][j] != 0:
      cost = graph[i][j]
      jump = [(cost, 0), (0, cost)]
      for k in range(2):
        nx = i + jump[k][0]
        ny = j + jump[k][1]
        if 0 <= nx < n and 0 <= ny < n:
          dp[nx][ny] += dp[i][j]

print(dp[n - 1][n - 1])
