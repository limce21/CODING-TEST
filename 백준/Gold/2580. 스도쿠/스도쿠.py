import sys

input = sys.stdin.readline


def sudoku(cnt):

  if (cnt == len(z_list)):
    for i in data:
      print(*i)
    exit(0)

  x, y = z_list[cnt]
  if data[x][y] == 0:
    check = [False] * 10
    for i in range(9):
      check[data[i][y]] = True
      check[data[x][i]] = True
    for i in range(3):
      for j in range(3):
        check[data[(x // 3) * 3 + i][(y // 3) * 3 + j]] = True
    for i in range(1, 10):
      if not check[i]:
        data[x][y] = i
        sudoku(cnt + 1)
        data[x][y] = 0


data = []
z_list = []
for i in range(9):
  arr = list(map(int, input().split()))
  for j in range(9):
    if arr[j] == 0:
      z_list.append([i, j])
  data.append(arr)

sudoku(0)