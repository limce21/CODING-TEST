import sys

input = sys.stdin.readline


def dfs(x, y, cnt):
  global answer
  if x == 0 and y == c - 1 and cnt == k:
    answer += 1
    return
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < r and 0 <= ny < c and data[nx][ny] == '.':
      data[nx][ny] = 'T'
      dfs(nx, ny, cnt + 1)
      data[nx][ny] = '.'


r, c, k = map(int, input().split())
data = []
for _ in range(r):
  data.append(list(input().rstrip()))
answer = 0
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

data[r-c][0] = 'T'
dfs(r - 1, 0, 1)
print(answer)
