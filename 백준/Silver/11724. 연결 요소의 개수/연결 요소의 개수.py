import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(start):
  visited[start] = True
  for i in graph[start]:
    if not visited[i]:
      visited[i] = True
      dfs(i)
  return True


n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for i in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

cnt = 0
for i in range(1, n + 1):
  if not visited[i]:
    dfs(i)
    cnt += 1

print(cnt)