import sys
import re

input = sys.stdin.readline

n = int(input())
sign = input().rstrip().replace('*','.*')
p = re.compile(sign)
for _ in range(n):
  string = input().rstrip()
  m = p.fullmatch(string)
  if m: print("DA")
  else: print("NE")
