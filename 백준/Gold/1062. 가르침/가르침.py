import sys
input = sys.stdin.readline

def calc(visited):
  global answer
  cnt = 0
  for word in words:
    flag = False
    for alpha in word:
      if not visited[ord(alpha)-97]:
        flag = True
        break
    if not flag:
      cnt+=1
  answer = max(answer, cnt)

def backtracking(cnt, idx, visited):
  if cnt == k:
    calc(visited)
    return
  for i in range(idx+1, 26):
    if not visited[i]:
      visited[i] = True
      backtracking(cnt+1, i, visited)
      visited[i] = False
  
n, k = map(int, input().split())
words = []
answer = 0
for _ in range(n):
  words.append(list(set(input().rstrip())))
if k < 5:
  print(0)
else:
  visited = [False] * (26)
  visited[0] = True
  visited[2] = True
  visited[8] = True
  visited[13] = True
  visited[19] = True
  backtracking(5, 0, visited)
  print(answer)