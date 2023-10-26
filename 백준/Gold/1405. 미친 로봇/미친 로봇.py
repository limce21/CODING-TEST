import sys
input = sys.stdin.readline

def back_tracking(cnt, x, y, nv):
  if cnt == n:
    global answer
    answer += nv
    return
  visited[x][y] = True    
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < 29 and 0 <= ny < 29 and not visited[nx][ny]:
        back_tracking(cnt+1, nx, ny, nv * dp[i])
        visited[nx][ny] = False

n, pe, pw, ps, pn = map(int, input().split())
dp = [pe/100, pw/100, ps/100, pn/100]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
visited = [[False] * (29) for _ in range(29)]
total = 0
answer = 0
back_tracking(0, n, n, 1)
print(answer)