import sys


def quad_tree(x, y, n):
  black, white = 0, 0
  for i in range(x, x + n):
    for j in range(y, y + n):
      if data[i][j] == '1':
        black += 1
      else:
        white += 1
  if black == 0 or white == 0:
    if black == 0:
      result.append('0')
    else:
      result.append('1')
  else:
    result.append('(')
    quad_tree(x, y, n // 2)
    quad_tree(x, y + n // 2, n // 2)
    quad_tree(x + n // 2, y, n // 2)
    quad_tree(x + n // 2, y + n // 2, n // 2)
    result.append(')')


n = int(sys.stdin.readline())
data = []
result = []
for _ in range(n):
  data.append(list(sys.stdin.readline().rstrip()))

quad_tree(0, 0, n)
print(''.join(result))