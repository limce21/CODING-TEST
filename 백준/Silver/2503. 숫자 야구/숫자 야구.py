import sys
from itertools import permutations

n = int(sys.stdin.readline().rstrip())
data = list(permutations([str(i + 1) for i in range(9)], 3))

for _ in range(n):
  answer, s, b = map(int, sys.stdin.readline().rstrip().split())
  answer = list(str(answer))
  rmcnt = 0
  for i in range(len(data)):
    strike, ball = 0, 0
    i -= rmcnt
    for j in range(3):
      if data[i][j] == answer[j]:
        strike += 1
      elif answer[j] in data[i]:
        ball += 1
    if strike != s or ball != b:
      data.remove(data[i])
      rmcnt += 1

print(len(data))
