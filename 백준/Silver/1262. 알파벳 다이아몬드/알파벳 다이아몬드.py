import sys

n, r1, c1, r2, c2 = map(int, sys.stdin.readline().split())
graph = []
w = 2 * n - 1

row = r1
for i in range(r2 - r1 + 1):
  arr = []
  col = c1
  for j in range(c2 - c1 + 1):
    x = row % w
    y = col % w
    dist = abs(n - 1 - x) + abs(n - 1 - y)
    if dist > n - 1:
      arr.append('.')
    else:
      arr.append(chr(97 + (dist % 26)))
    col += 1
  graph.append(arr)
  row += 1

for i in graph:
  print(''.join(i))