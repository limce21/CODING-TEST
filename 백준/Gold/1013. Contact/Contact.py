import sys
import re

input = sys.stdin.readline

t = int(input())
for _ in range(t):
  microwave = input().rstrip()
  p = re.compile('(100+1+|01)+')
  m = p.fullmatch(microwave)
  if m: print("YES")
  else: print("NO")
