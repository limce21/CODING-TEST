import sys

input = sys.stdin.readline

def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b


while True:
  m, n = map(int, input().split())
  if m == 0 and n == 0:
    break
  parent = [i for i in range(m)]
  edges = []
  result = 0
  for _ in range(n):
    x, y, z = map(int, input().split())
    edges.append((z, x, y))
    result += z
    
  edges.sort()
  
  for edge in edges:
    z, x, y = edge
    if find_parent(parent, x) != find_parent(parent, y):
      union_parent(parent, x, y)
      result -= z

  print(result)

