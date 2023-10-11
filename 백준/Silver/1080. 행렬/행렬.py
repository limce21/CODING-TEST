import sys

input = sys.stdin.readline
INF = int(1e9)


def change(x, y, matrix):
  for i in range(3):
    for j in range(3):
      if matrix[x+i][y+j] == 0:
        matrix[x+i][y+j] = 1
      else:
        matrix[x+i][y+j] = 0
  return matrix

def check(x, y, matrix):
  for i in range(3):
    for j in range(3):
      if visited[i][j]:
        return False
  return True

n, m = map(int, input().split())
default_matrix = []
answer = 0
for _ in range(n):
  arr = list(input().rstrip())
  default_matrix.append(list(map(int, arr)))

change_matrix = []
for _ in range(n):
  arr = list(input().rstrip())
  change_matrix.append(list(map(int, arr)))

visited = [[False] * m for _ in range(n)]

for i in range(n):
  for j in range(m):
    if default_matrix[i][j] != change_matrix[i][j]:
      if i+2 < n and j+2 < m and check(i, j, default_matrix):
        change(i, j, default_matrix)
        answer += 1

for i in range(n):
  for j in range(m):
    if default_matrix[i][j] != change_matrix[i][j]:
      print(-1)
      exit()

print(answer)