import sys
from bisect import bisect_left
from math import ceil

input = sys.stdin.readline

def solution(n, files):
  files.sort()
  answer = 0
  for i in range(n):
    val = ceil(files[i] * 0.9)
    bisect_idx = bisect_left(files, val)
    answer += (i - bisect_idx)
  print(answer)


n = int(input())
files = list(map(int, input().split()))
solution(n, files)
