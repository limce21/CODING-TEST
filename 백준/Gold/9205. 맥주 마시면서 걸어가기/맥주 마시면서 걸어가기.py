import sys
input = sys.stdin.readline
INF = int(1e9)

t = int(input()) # 테스트 개수
for _ in range(t):
  n = int(input()) # 편의점 개수
  lst = [] 
  for _ in range(n+2):
    x, y = map(int, input().split())
    lst.append((x, y))

  graph = [[INF] * (n+2) for _ in range(n+2)]
  for i in range(n+2):
    for j in range(n+2):
      dist = abs(lst[i][0] - lst[j][0]) + abs(lst[i][1] - lst[j][1])
      if(dist <= 1000):
        graph[i][j] = 0
        graph[j][i] = 0
  

  for k in range(n+2):
    for a in range(n+2):
      for b in range(n+2):
        graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

  if graph[0][n+1] >= INF:
    print("sad")
  else:
    print("happy")