import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
data = []

for _ in range(n):
  arr = list(sys.stdin.readline().rstrip())
  data.append(list(map(int, arr)))

max_width = 1
for i in range(n):
  for j in range(m):
    for k in range(j + 1, m):
      if data[i][j] == data[i][k]:
        sub = k - j
        if i + sub < n and data[i][j] == data[i + sub][j] and data[
            i + sub][j] == data[i + sub][k]:
          max_width = max(max_width, (sub + 1)**2)

print(max_width)
