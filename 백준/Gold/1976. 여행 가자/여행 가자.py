import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
parent = [i for i in range(n+1)]

def find_parent(x):
  if parent[x] != x:
    parent[x] = find_parent(parent[x])
  return parent[x]

def union(a, b):
  a = find_parent(a)
  b = find_parent(b)
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

for i in range(n):
  arr = list(map(int, input().split()))
  for j in range(n):
    if arr[j] == 1:
      union(i+1, j+1)

path = list(map(int, input().split()))
start = parent[path[0]]
for i in range(1, m):
  if parent[path[i]] != start:
    print("NO")
    break
else:
  print("YES")