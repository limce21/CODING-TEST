import sys

input = sys.stdin.readline

def find_parent(x):
  if parent[x] != x:
    parent[x] = find_parent(parent[x])
  return parent[x]

def union(a, b, idx):
  global answer
  a = find_parent(a)
  b = find_parent(b)
  if a != b:
    parent[max(a, b)] = min(a, b)
  elif answer == 0:
    answer = idx

n,m = map(int, input().split())
parent = [i for i in range(n)]
answer = 0

for i in range(m):
  n1, n2 = map(int, input().split())
  union(n1, n2, i+1)

print(answer)