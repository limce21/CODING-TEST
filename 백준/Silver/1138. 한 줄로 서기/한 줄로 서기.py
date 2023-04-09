import sys
from itertools import permutations

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
num = [i + 1 for i in range(n)]
num = permutations(num, n)

for i in num:
  temp = []
  for j in range(1, n + 1):
    cnt = 0
    for k in range(n):
      if i[k] == j:
        temp.append(cnt)
        break
      if i[k] > j:
        cnt += 1
  if temp == data:
    print(' '.join(map(str,i)))