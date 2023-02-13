import sys

n = int(sys.stdin.readline().rstrip())

cow_arr = [-1] * 11

result = 0

for _ in range(n):
  num, dir = map(int, sys.stdin.readline().rstrip().split())
  if cow_arr[num] != dir and cow_arr[num] != -1:
    result += 1
  cow_arr[num] = dir

print(result)