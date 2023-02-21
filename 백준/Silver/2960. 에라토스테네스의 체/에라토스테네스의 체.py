import sys
import math

n, k = map(int, sys.stdin.readline().rstrip().split())
data = [True for _ in range(n + 1)]

count = 0
for i in range(2, n + 1):
  if data[i] == True:
    j = 1
    while i * j <= n:
      if data[i * j] == True:
        data[i * j] = False
        count += 1
        if count == k:
          print(i * j)
          break
      j += 1
      
      
