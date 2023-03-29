import sys
import math

input = sys.stdin.readline

t = int(input())

for _ in range(t):
  x1, y1, r1, x2, y2, r2 = map(int, input().split())
  d = (x1 - x2)**2 + (y1 - y2)**2
  r_sub = (r1 - r2)**2
  r_sum = (r1 + r2)**2
  result = 0

  if d == 0 and r1 == r2:
    result = -1
  elif r_sub < d < r_sum:
    result = 2
  elif r_sub == d or r_sum == d:
    result = 1
  elif d > r_sum or d < r_sub:
    result = 0

  print(result)
