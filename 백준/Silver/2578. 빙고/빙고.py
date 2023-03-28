import sys

input = sys.stdin.readline

data = []
visit = [[0] * 5 for _ in range(5)]


def findIndex(value):
  for a in range(5):
    for b in range(5):
      if data[a][b] == value:
        return a, b


def isBingo():
  bingo = 0
  for a in range(5):
    bingo_row = 0
    for b in range(5):
      if visit[a][b]:
        bingo_row += 1
    if bingo_row == 5:
      bingo += 1

  for a in range(5):
    bingo_column = 0
    for b in range(5):
      if visit[b][a]:
        bingo_column += 1
    if bingo_column == 5:
      bingo += 1

  bingo_left_diag = 0
  for a in range(5):
    for b in range(5):
      if a == b and visit[a][b]:
        bingo_left_diag += 1
  if bingo_left_diag == 5:
    bingo += 1

  bingo_right_diag = 0
  for a in range(5):
    for b in range(5):
      if a + b == 4 and visit[a][b]:
        bingo_right_diag += 1

  if bingo_right_diag == 5:
    bingo += 1
  return bingo


for _ in range(5):
  data.append(list(map(int, input().split())))

talk = []
for i in range(5):
  arr = list(map(int, input().split()))
  talk.append(arr)

bingo_val = 0
answer = []

for i in range(5):
  for j in range(5):
    r, c = findIndex(talk[i][j])
    visit[r][c] = True
    bingo_val = isBingo()
    if bingo_val >= 3:
      answer.append(i * 5 + (j + 1))

print(answer[0])
