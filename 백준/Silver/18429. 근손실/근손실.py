import sys
from itertools import permutations

input = sys.stdin.readline

n, k = map(int, input().split())
a = list(map(int, input().split()))
cases = list(permutations(a, n))

answer = 0
for case in cases:
  mass = 500
  flag = False
  for i in range(n):
    mass += case[i]
    mass -= k
    if mass < 500:
      flag = True
      break
  if not flag:
    answer += 1

print(answer)