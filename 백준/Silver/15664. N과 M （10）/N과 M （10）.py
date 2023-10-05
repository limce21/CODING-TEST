import sys

input = sys.stdin.readline

answer = set([])

def combs(idx, cnt):
  if cnt == m:
    tmp = []
    for i in range(n):
      if is_used[i]:
        tmp.append(data[i])
    answer.add(tuple(tmp))
    return
  for i in range(idx, n):
    is_used[i] = True
    combs(i+1, cnt+1)
    is_used[i] = False

n, m = map(int, input().split())
data = list(map(int, input().split()))
is_used = [False] * (n)
data.sort()

combs(0,0)
answer = list(answer)
answer.sort()

for i in answer:
  print(*list(i))