import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())

data = []

for _ in range(n):
  data.append(input().rstrip())

counter = Counter(data)
data = dict(counter)
data = list(data.items())

data.sort(key=lambda x: (-x[1], int(x[0])))

print(int(data[0][0]))
