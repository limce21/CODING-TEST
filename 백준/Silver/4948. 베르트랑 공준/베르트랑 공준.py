import sys
import math

data = [True for i in range(2 * 123456 + 1)]

while 1:
  n = int(sys.stdin.readline().rstrip())
  if n == 0:
    break
  for i in range(2, int(math.sqrt(2 * n)) + 1):
    if data[i] == True:
      j = 2
      while i * j <= 2 * n:
        data[i * j] = False
        j += 1
  result = 0
  for i in range(n+1, 2 * n + 1):
    if data[i] == True:
      result += 1
  print(result)
