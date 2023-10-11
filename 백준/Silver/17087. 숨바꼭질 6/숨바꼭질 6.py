import sys

input = sys.stdin.readline

def gcd(a, b):
  while b:
    mod = b
    b = a % b
    a = mod
  return a

n, s = map(int, input().split())
a_lst = list(map(int, input().split()))
d_lst = list(set(map(lambda x: abs(s - x), a_lst)))
d = min(d_lst)

for item in d_lst:
  d = gcd(item, d)

print(d)