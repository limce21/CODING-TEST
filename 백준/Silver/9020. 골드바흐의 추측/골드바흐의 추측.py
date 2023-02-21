import sys
import math

t = int(sys.stdin.readline().rstrip())
data = [True for _ in range(10001)]
data[1] = False

for i in range(2, int(math.sqrt(10000)) + 1):
  if data[i] == True:
    j = 2
    while i * j <= 10000:
      data[i * j] = False
      j += 1
        
for _ in range(t):
  n = int(sys.stdin.readline().rstrip())
  result = []
  for i in range(2, n // 2 + 1):
    if data[i] == True and data[n - i] == True:
      result.append((i, n - i))
  x, y = result[-1]
  print(x, y)