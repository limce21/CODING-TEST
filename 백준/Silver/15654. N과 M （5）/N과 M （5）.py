import sys
from itertools import permutations

input = sys.stdin.readline

n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort()

perms = list(permutations(data, m))

for p in perms:
  print(*p)
