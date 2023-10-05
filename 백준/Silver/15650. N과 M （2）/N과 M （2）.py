import sys
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
data = [i+1 for i in range(n)]

combs = list(combinations(data, m))

for c in combs:
  print(*c)