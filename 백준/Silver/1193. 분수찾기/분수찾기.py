import sys
import math

x = int(sys.stdin.readline())
# 등차수열의 합은 n * (n+1) / 2

i = 1
while 1:
  if x <= int(i * (i + 1) / 2):
    break
  else:
    i += 1

cnt = int(i * (i - 1) / 2) + 1
if i % 2 == 0:
  print(f"{x - cnt + 1}/{i - (x - cnt)}")
else:
  print(f"{i - (x - cnt)}/{x - cnt + 1}")