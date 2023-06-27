import sys
import copy

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

mode = {
  1: [[0], [1], [2], [3]],
  2: [[0, 1], [2, 3]],
  3: [[0, 2], [0, 3], [1, 2], [1, 3]],
  4: [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
  5: [[0, 1, 2, 3]]
}

input = sys.stdin.readline
N, M = map(int, input().split())


def watch(x, y, direction, tmp):
  for d in direction:
    nx, ny = x, y
    while True:
      nx += dx[d]
      ny += dy[d]
      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        break
      if tmp[nx][ny] == 6:
        break
      if tmp[nx][ny] == 0:
        tmp[nx][ny] = '#'


def dfs(n, graph):
  global answer
  tmp = copy.deepcopy(graph)

  if n == len(cctv):
    count = 0
    for t in tmp:
      count += t.count(0)
    answer = min(answer, count)
    return

  x, y, m = cctv[n]
  for dir in mode[m]:
    watch(x, y, dir, tmp)
    dfs(n + 1, tmp)
    tmp = copy.deepcopy(graph)


graph = []
cctv = []
answer = int(1e9)
for x in range(N):
  data = list(map(int, input().split()))
  graph.append(data)
  for y in range(M):
    if data[y] != 0 and data[y] != 6:
      cctv.append([x, y, data[y]])

dfs(0, graph)
print(answer)