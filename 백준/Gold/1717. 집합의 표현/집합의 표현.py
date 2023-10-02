import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline


def find_parent(x):
  if parent[x] != x:
    parent[x] = find_parent(parent[x])
  return parent[x]


def union(a, b):
  a = find_parent(a)
  b = find_parent(b)
  if a < b:
    parent[b] = a
  elif a > b:
    parent[a] = b


def same_parent(a, b):
  a = find_parent(a)
  b = find_parent(b)
  if a == b:
    return "YES"
  return "NO"


n, m = map(int, input().split())
parent = [i for i in range(n+1)]

for _ in range(m):
  op, a, b = map(int, input().split())
  if op == 0:
    union(a, b)
  else:
    print(same_parent(a, b))
