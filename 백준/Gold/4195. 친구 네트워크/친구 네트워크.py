import sys

input = sys.stdin.readline

def find(x):
  if parent[x] != x:
    parent[x] = find(parent[x])
  return parent[x]

def union(a,b):
  a = find(a)
  b = find(b)
  if a != b:
    parent[b] = a
    counter[a] += counter[b]

t = int(input())

for _ in range(t):
  parent = {}
  counter = {}
  f = int(input())
  for i in range(f):
    f1, f2 = input().rstrip().split()
    if f1 not in parent:
      parent[f1] = f1
      counter[f1] = 1
    if f2 not in parent:
      parent[f2] = f2
      counter[f2] = 1

    union(f1, f2)
    print(counter[find(f1)])