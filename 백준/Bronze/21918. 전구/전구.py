import sys

n, m = map(int, sys.stdin.readline().rstrip().split())

arr = list(map(int, sys.stdin.readline().rstrip().split()))

for _ in range(m):
  a, b, c = map(int, sys.stdin.readline().rstrip().split())
  if a == 1:
    arr[b - 1] = c
  elif a == 2:
    for i in range(b - 1, c):
      arr[i] = abs(arr[i] - 1)
  elif a == 3:
    for i in range(b - 1, c):
      arr[i] = 0
  else:
    for i in range(b - 1, c):
      arr[i] = 1

print(" ".join(map(str, arr)))
