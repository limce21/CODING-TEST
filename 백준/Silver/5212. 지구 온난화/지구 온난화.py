import sys
import copy

INF = int(1e9)

r, c = map(int, sys.stdin.readline().split())
data = []

di = [0, 0, 1, -1]
dj = [1, -1, 0, 0]

for _ in range(r):
  data.append(list(sys.stdin.readline().rstrip()))

result = copy.deepcopy(data)

for i in range(r):
  for j in range(c):
    if data[i][j] == ".":
      continue
    cnt = 0
    for k in range(4):
      ni = i + di[k]
      nj = j + dj[k]
      if ni < 0 or ni >= r or nj < 0 or nj >= c:
        cnt += 1
        continue
      if data[ni][nj] == '.':
        cnt += 1
    if cnt >= 3:
      result[i][j] = '.'

min_row = INF
for i in range(r):
  for j in range(c):
    if result[i][j] == 'X':
      min_row = min(min_row, i)

max_row = 0
for i in range(r):
  for j in range(c):
    if result[i][j] == 'X':
      max_row = max(max_row, i)

min_col = INF
for i in range(r):
  for j in range(c):
    if result[i][j] == 'X':
      min_col = min(min_col, j)

max_col = 0
for i in range(r):
  for j in range(c):
    if result[i][j] == 'X':
      max_col = max(max_col, j)

for i in range(min_row, max_row + 1):
  for j in range(min_col, max_col + 1):
    print(result[i][j], end='')
  print()