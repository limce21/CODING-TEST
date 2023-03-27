import sys

input = sys.stdin.readline


def solution(x, y, now):
  global result, r, c, answer
  if now == 2:
    for i in range(x, x + 2):
      for j in range(y, y + 2):
        if i == r and j == c:
          answer = result
          return
        else:
          result += 1
  dx = [0, 0, now // 2, now // 2]
  dy = [0, now // 2, 0, now // 2]
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx <= r < nx + now // 2 and ny <= c < ny + now // 2:
      solution(nx, ny, now // 2)
    else:
      result += (now // 2)**2
  return


n, r, c = map(int, input().split())
N = 2**n

result = 0
answer = 0
solution(0, 0, N)
print(answer)
