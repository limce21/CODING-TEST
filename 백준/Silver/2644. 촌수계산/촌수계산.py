import sys

input = sys.stdin.readline


def dfs(v, cnt):
  global answer
  if v == b:
    answer = cnt
    return
  for i in data[v]:
    if not visited[i]:
      visited[i] = True
      dfs(i, cnt + 1)


n = int(input())
a, b = map(int, input().split())
m = int(input())
data = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
answer = -1
for _ in range(m):
  x, y = map(int, input().split())
  data[x].append(y)
  data[y].append(x)

visited[a] = True
dfs(a, 0)
print(answer)
