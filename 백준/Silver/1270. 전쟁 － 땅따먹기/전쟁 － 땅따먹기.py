import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())
for _ in range(n):
  data = list(map(int, input().split()))
  t = data[0]
  counter = list(Counter(data[1:]).items())
  counter.sort(key=lambda x: (-x[1], x[0]))
  if counter[0][1] > t // 2:
    print(counter[0][0])
  else:
    print("SYJKGW")