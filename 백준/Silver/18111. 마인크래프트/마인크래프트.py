import sys
from itertools import chain
from collections import Counter

input = sys.stdin.readline
n, m, b = map(int, input().split())

ground = []
for _ in range(n):
  ground.append(list(map(int, input().split())))

counter = list(Counter(list(chain(*ground))).items())

min_cost = int(1e9)
for floor in range(257):
  del_cost, isrt_cost = 0, 0
  for i in counter:
    target, num = i
    if target >= floor:
      del_cost += (target-floor) * num
    else:
      isrt_cost += (floor-target) * num
  if del_cost + b >= isrt_cost:
    if del_cost * 2 + isrt_cost <= min_cost:
      min_cost = del_cost * 2 + isrt_cost
      answer = (min_cost, floor)

print(*answer)
    
