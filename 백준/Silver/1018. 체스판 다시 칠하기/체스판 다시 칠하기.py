import sys

chess_board_white = [['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W']]
chess_board_black = [['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B'],['B','W','B','W','B','W','B', 'W'],['W','B','W','B','W','B','W','B']]

n, m = map(int, sys.stdin.readline().rstrip().split())
data = []
for _ in range(n):
  data.append(list(sys.stdin.readline().rstrip()))

count = []
for i in range(n - 7):
  for j in range(m - 7):
    black_result = 0
    white_result = 0
    x = 0
    y = 0
    for a in range(i, 8 + i):
      for b in range(j , 8 + j):
        if data[a][b] != chess_board_black[x][y]:
          black_result += 1
        if data[a][b] != chess_board_white[x][y]:
          white_result += 1
        y += 1
      x += 1
      y = 0
    count.append(min(black_result, white_result))

print(min(count))