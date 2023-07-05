import sys

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]


def dfs(x, y, cnt):
  global answer
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx < 0 or nx >= r or ny < 0 or ny >= c:
      answer = max(answer, cnt)
      continue
    if alpha[ord(board[nx][ny]) - 65]:
      answer = max(answer, cnt)
      continue
    alpha[ord(board[nx][ny]) - 65] = True
    dfs(nx, ny, cnt + 1)
    alpha[ord(board[nx][ny]) - 65] = False


r, c = map(int, sys.stdin.readline().split())
alpha = [False] * 26

board = []
answer = 0
for _ in range(r):
  board.append(list(sys.stdin.readline().rstrip()))

alpha[ord(board[0][0]) - 65] = True
dfs(0, 0, 1)
print(answer)
