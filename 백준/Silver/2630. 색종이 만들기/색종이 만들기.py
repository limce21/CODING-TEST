import sys

input = sys.stdin.readline

def solution(x, y, N):
  global white, blue
  color = data[x][y]
  for i in range(x, x + N):
    for j in range(y, y + N):
      if color != data[i][j]:
        solution(x, y, N // 2)
        solution(x + N // 2, y, N // 2)
        solution(x, y + N // 2, N // 2)
        solution(x + N // 2, y + N // 2, N // 2)
        return
  if color == 0:
    white += 1
  else:
    blue += 1


n = int(input())

data = []
white = 0
blue = 0

for _ in range(n):
  data.append(list(map(int, input().split())))

solution(0, 0, n)
print(white)
print(blue)