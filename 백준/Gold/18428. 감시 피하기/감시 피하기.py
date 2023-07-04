import sys
from itertools import combinations
import copy

sys.setrecursionlimit(1000000)
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(x, y, tmp):
  for i in range(4):
    nx = x
    ny = y
    while 1:
      nx += dx[i]
      ny += dy[i]
      if nx < 0 or nx >= n or ny < 0 or ny >= n:
        break
      if tmp[nx][ny] == 'O':
        break
      if tmp[nx][ny] == 'S':
        tmp[nx][ny] = 'X'

n = int(sys.stdin.readline())

corridors = []
graph = []
s_cnt = 0

for i in range(n):
  data = list(sys.stdin.readline().rstrip().split())
  graph.append(data)
  for j in range(n):
    if data[j] == 'X':
      corridors.append((i, j))
    if data[j] == 'S':
      s_cnt += 1

combs = list(combinations(corridors, 3))
answer = "NO"

for c in combs:
  tmp = copy.deepcopy(graph)

  cnt = 0
  for idx in c:
    i, j = idx
    tmp[i][j] = 'O'

  if tmp == [['X', 'S', 'X', 'O', 'T'], ['T', 'O', 'S', 'X', 'X'], ['X', 'X', 'O', 'X', 'X'], ['X', 'T', 'X', 'X', 'X'], ['X', 'X', 'T', 'X', 'X']]:
    for i in tmp:
      print(i)
    print()
    for i in range(n):
      for j in range(n):
        if tmp[i][j] == 'T':
          dfs(i, j, tmp)
    for i in tmp:
      print(i)
    print()
  else:
    for i in range(n):
      for j in range(n):
        if tmp[i][j] == 'T':
          dfs(i, j, tmp)
        
  for k in range(n):
    cnt += tmp[k].count('S')

  if cnt == s_cnt:
    answer = "YES"
    break

print(answer)


