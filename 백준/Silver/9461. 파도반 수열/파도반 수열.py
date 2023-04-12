import sys

t = int(sys.stdin.readline())
data = [0, 1, 1]

for i in range(3, 101):
  data.append(data[i - 3] + data[i - 2])

for _ in range(t):
  n = int(sys.stdin.readline())
  print(data[n])
