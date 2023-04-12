import sys

data = [0, 1, 3]
for i in range(3, 1001):
  data.append(data[i - 2] * 2 + data[i - 1])

n = int(sys.stdin.readline())
print(data[n] % 10007)
