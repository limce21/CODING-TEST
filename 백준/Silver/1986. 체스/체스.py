import sys
from collections import Counter
from itertools import chain

input = sys.stdin.readline

QUEEN_VALUE = 1
KNIGHT_VALUE = 2
PAWN_VALUE = 3
QUEEN_NEW = 4


def initial_setting():
  for i in range(queen_info[0]):
    x, y = queen_info[i * 2 + 1], queen_info[i * 2 + 2]
    chess[x - 1][y - 1] = QUEEN_VALUE
  for i in range(knight_info[0]):
    x, y = knight_info[i * 2 + 1], knight_info[i * 2 + 2]
    chess[x - 1][y - 1] = KNIGHT_VALUE
  for i in range(pawn_info[0]):
    x, y = pawn_info[i * 2 + 1], pawn_info[i * 2 + 2]
    chess[x - 1][y - 1] = PAWN_VALUE


def queen_setting():
  for i in range(queen_info[0]):
    x, y = queen_info[i * 2 + 1] - 1, queen_info[i * 2 + 2] - 1
    for j in range(x - 1, -1, -1):
      if chess[j][y] == 0 or chess[j][y] == 4:
        chess[j][y] = QUEEN_NEW
      else:
        break
    for j in range(x + 1, n):
      if chess[j][y] == 0 or chess[j][y] == 4:
        chess[j][y] = QUEEN_NEW
      else:
        break
    for j in range(y - 1, -1, -1):
      if chess[x][j] == 0 or chess[x][j] == 4:
        chess[x][j] = QUEEN_NEW
      else:
        break
    for j in range(y + 1, m):
      if chess[x][j] == 0 or chess[x][j] == 4:
        chess[x][j] = QUEEN_NEW
      else:
        break
    j = 1
    while 1:
      if x - j < 0 or y - j < 0:
        break
      if chess[x - j][y - j] == 0 or chess[x - j][y - j] == 4:
        chess[x - j][y - j] = QUEEN_NEW
        j += 1
      else:
        break
    j = 1
    while 1:
      if x + j >= n or y - j < 0:
        break
      if chess[x + j][y - j] == 0 or chess[x + j][y - j] == 4:
        chess[x + j][y - j] = QUEEN_NEW
        j += 1
      else:
        break
    j = 1
    while 1:
      if x + j >= n or y + j >= m:
        break
      if chess[x + j][y + j] == 0 or chess[x + j][y + j] == 4:
        chess[x + j][y + j] = QUEEN_NEW
        j += 1
      else:
        break
    j = 1
    while 1:
      if x - j < 0 or y + j >= m:
        break
      if chess[x - j][y + j] == 0 or chess[x - j][y + j] == 4:
        chess[x - j][y + j] = QUEEN_NEW
        j += 1
      else:
        break


def knight_setting():
  knight_dir = [(1, 2), (-1, -2), (1, -2), (-1, 2), (2, 1), (-2, 1), (2, -1),
                (-2, -1)]
  for i in range(knight_info[0]):
    x, y = knight_info[i * 2 + 1], knight_info[i * 2 + 2]
    for dir in knight_dir:
      dx, dy = dir
      nx = x - 1 + dx
      ny = y - 1 + dy
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if chess[nx][ny] == 0:
        chess[nx][ny] = KNIGHT_VALUE


n, m = map(int, input().split())
queen_info = list(map(int, input().split()))
knight_info = list(map(int, input().split()))
pawn_info = list(map(int, input().split()))

chess = [[0] * m for _ in range(n)]

initial_setting()
queen_setting()
knight_setting()

counter = Counter(list(chain(*chess)))
print(counter[0])
