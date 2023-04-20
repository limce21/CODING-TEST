import sys
from bisect import bisect_left

input = sys.stdin.readline

n = int(input())
x_list = list(map(int, input().split()))
sorted_x_list = sorted(list(set(x_list)))

for x in x_list:
  print(bisect_left(sorted_x_list, x), end=" ")
