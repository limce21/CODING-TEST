from itertools import combinations
import sys

input = sys.stdin.readline

while 1:
  data = list(map(int, input().split()))
  k = data[0]
  if k == 0:
    break
  s = data[1:]
  cases = list(combinations(s, 6))
  for case in cases:
    print(*case)
  print()