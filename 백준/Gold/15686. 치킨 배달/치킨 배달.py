import sys
from itertools import combinations

INF = int(1e9)

input = sys.stdin.readline


def distance(chickens):
  copy_dir = home_dir.copy()
  for chicken in chickens:
    ci, cj = chicken
    for home in home_keys:
      hi, hj = home
      copy_dir[home] = min(copy_dir[home], abs(hi - ci) + abs(hj - cj))
  return sum(list(copy_dir.values()))


n, m = map(int, input().split())
city = []
for _ in range(n):
  city.append(list(map(int, input().split())))

chicken_indexs = []
home_dir = {}
for i in range(n):
  for j in range(n):
    if city[i][j] == 2:
      chicken_indexs.append((i, j))
    elif city[i][j] == 1:
      home_dir[(i, j)] = INF

home_keys = list(home_dir.keys())
chicken_combinations = list(combinations(chicken_indexs, m))
result = INF
for chick_comb in chicken_combinations:
  result = min(result, distance(chick_comb))

print(result)