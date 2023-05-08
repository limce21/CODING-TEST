import sys

input = sys.stdin.readline


def cut(x, y, n):
  zero, minus, plus = 0, 0, 0
  for i in range(x, x + n):
    for j in range(y, y + n):
      if data[i][j] == 0:
        zero += 1
      elif data[i][j] == 1:
        plus += 1
      else:
        minus += 1
  if zero == n**2:
    zero_list.append(0)
  elif minus == n**2:
    minus_list.append(-1)
  elif plus == n**2:
    plus_list.append(1)
  else:
    cut(x, y, n // 3)
    cut(x + n // 3, y, n // 3)
    cut(x + 2 * n // 3, y, n // 3)
    cut(x, y + n // 3, n // 3)
    cut(x + n // 3, y + n // 3, n // 3)
    cut(x + 2 * n // 3, y + n // 3, n // 3)
    cut(x, y + 2 * n // 3, n // 3)
    cut(x + n // 3, y + 2 * n // 3, n // 3)
    cut(x + 2 * n // 3, y + 2 * n // 3, n // 3)


n = int(input())
data = []
zero_list = []
minus_list = []
plus_list = []

for _ in range(n):
  data.append(list(map(int, input().split())))

cut(0, 0, n)
print(len(minus_list))
print(len(zero_list))
print(len(plus_list))