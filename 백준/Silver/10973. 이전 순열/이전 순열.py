import sys
from itertools import permutations

input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))

for i in range(n-1,0,-1):
  if data[i-1] > data[i]:
    for j in range(n-1,0,-1):
      if data[i-1] > data[j]:
        data[i-1], data[j] = data[j], data[i-1]
        data = data[:i] + sorted(data[i:], reverse=True)
        print(*data)
        exit()

print(-1)
