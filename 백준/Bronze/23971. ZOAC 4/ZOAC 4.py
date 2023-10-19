import sys
input = sys.stdin.readline

h,w,n,m = map(int, input().split())
answer = 0
if w % (m+1) == 0:
  width_cnt = w // (m+1)
else:
  width_cnt = w // (m+1) + 1
if h % (n+1) == 0:
  height_cnt = h // (n+1)
else:
  height_cnt = h // (n+1) + 1

answer = width_cnt * height_cnt
print(answer)