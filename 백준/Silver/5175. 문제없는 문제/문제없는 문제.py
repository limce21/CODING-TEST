import sys
from itertools import combinations

input = sys.stdin.readline

k = int(input())
for i in range(1, k + 1):
  m, n = map(int, input().split())
  algorithm_set = {}
  algorithms = []
  answer = []
  for j in range(n):
    algorithms.append((list(map(int, input().split())), chr(65 + j)))
  flag = False
  for j in range(1, n + 1):
    combs = list(combinations(algorithms, j))
    for comb in combs:
      val = [c[0] for c in comb]
      sum_set = set(sum(val, []))
      if flag:
        break
      if len(sum_set) == m:
        answer = [c[1] for c in comb]
        flag = True
    if flag:
      break
  answer = ' '.join(answer)
  print(f"Data Set {i}: {answer}")
  print()
