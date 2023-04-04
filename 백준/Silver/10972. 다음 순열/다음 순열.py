import sys

n = int(sys.stdin.readline().rstrip())

data = list(map(int, sys.stdin.readline().rstrip().split()))

for i in range(n - 1, 0, -1):
  if data[i] > data[i - 1]:
    for j in range(n - 1, 0, -1):
      if data[j] > data[i - 1]:
        data[j], data[i - 1] = data[i - 1], data[j]
        data = data[:i] + sorted(data[i:])
        print(*data)
        exit()

print(-1)
