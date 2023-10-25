import sys
input = sys.stdin.readline
INF = int(1e9)

def calc():
  global answer
  sv = 1
  bv = 0
  for s, b in arr:
    sv *= s
    bv += b
  answer = min(answer, abs(sv-bv))

def back_tracking(cnt, idx, visited):
  if cnt == n+1:
    return
  else:
    if arr: 
      calc()
    for i in range(idx, n):
      if not visited[i]:
        arr.append(ingred[i])
        visited[i] = True
        back_tracking(cnt+1, i, visited)
        arr.pop()
        visited[i] = False

n = int(input())
ingred = []
arr = []
visited = [False] * (n)
answer = INF

for _ in range(n):
  s, b = map(int, input().split())
  ingred.append((s, b))

back_tracking(0, 0, visited)
print(answer)