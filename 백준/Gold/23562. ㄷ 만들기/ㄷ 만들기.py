import sys


def check(x, y, k):
  if x + k > n:
    return False
  if y + k > m:
    return False
  return True


def get_cost(x, y, k):
  global a, b
  cost = 0
  for i in range(n):
    for j in range(m):
      if x <= i < x + k and y <= j < y + k:
        if x + k // 3 <= i  < x + 2 * k // 3 and j >= y + k // 3:
          if data[i][j] == '#':
            cost += b
        else:
          if data[i][j] == '.':
            cost += a
      else:
        if data[i][j] == '#':
          cost += b
  return cost


input = sys.stdin.readline

n, m = map(int, input().split())
a, b = map(int, input().split())
data = []

for _ in range(n):
  arr = list(sys.stdin.readline().rstrip())
  data.append(arr)

k = min(n, m) // 3
result = int(1e9)
for i in range(1, k + 1):
  for x in range(n):
    for y in range(m):
      if check(x, y, i * 3):
        result = min(result, get_cost(x, y, i * 3))

print(result)