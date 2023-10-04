import sys


def find_parent(parent, x):
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]


def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  parent[b] = a


input = sys.stdin.readline

n = int(input())
parent = [i for i in range(n + 1)]
xlst, ylst, zlst = [], [], []

for i in range(n):
  x, y, z = map(int, input().split())
  xlst.append((x, i))
  ylst.append((y, i))
  zlst.append((z, i))

xlst.sort()
ylst.sort()
zlst.sort()

edges = []

for lst in xlst, ylst, zlst:
  for i in range(1, n):
    w1, a = lst[i - 1]
    w2, b = lst[i]
    edges.append((abs(w1 - w2), a, b))

edges.sort(reverse=True)
result = 0
cnt = n - 1

while cnt:
  w, a, b = edges.pop()
  if find_parent(parent, a) == find_parent(parent, b):
    continue
  union_parent(parent, a, b)
  cnt -= 1
  result += w

print(result)
