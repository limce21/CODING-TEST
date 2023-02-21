import sys
import math

m, n = map(int, sys.stdin.readline().rstrip().split())
data = [True] * (n+1)

for i in range(2, int(math.sqrt(n)) + 1):
  if data[i] == True:
    j = 2
    while (i * j <= n):
      data[i * j] = False
      j += 1

for i in range(m, n + 1):
  if data[i] == True and i != 1:
    print(i)