import sys


def star(x, y, n):
  if n == 3:
    for i in range(x, x + 3):
      for j in range(y, y + 3):
        if i == x + 1 and j == y + 1:
          continue
        else:
          square[i][j] = "*"
    return
  else:
    star(x, y, n // 3)
    star(x, y + n // 3, n // 3)
    star(x, y + 2 * n // 3, n // 3)
    star(x + n // 3, y, n // 3)
    star(x + n // 3, y + 2 * n // 3, n // 3)
    star(x + 2 * n // 3, y, n // 3)
    star(x + 2 * n // 3, y + n // 3, n // 3)
    star(x + 2 * n // 3, y + 2 * n // 3, n // 3)


n = int(sys.stdin.readline())
square = [[" "] * n for _ in range(n)]
star(0, 0, n)
for i in square:
  print(''.join(i))
