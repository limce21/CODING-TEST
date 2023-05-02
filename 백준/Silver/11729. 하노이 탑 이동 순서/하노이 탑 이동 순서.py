import sys


def hanoi(n, start, to, via):
  if n == 1:
    data.append((start, to))
  else:
    hanoi(n - 1, start, via, to)
    data.append((start, to))
    hanoi(n - 1, via, to, start)


data = []
n = int(sys.stdin.readline())
hanoi(n, '1', '3', '2')

print(len(data))
for i in data:
  print(*i)
