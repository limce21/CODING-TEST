import sys
input = sys.stdin.readline

# 0 1 2 3 4 5 6 7 8 9
# 10 
# 21 20
# 32 31 30
# 43 42 

n = int(input())
set_arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}

def backtracking(start):
  start_str = str(start)
  last_val = int(start_str[-1])
  for i in range(last_val-1, -1, -1):
    val = int(str(start) + str(i))
    set_arr.add(val)
    backtracking(val)

for s in range(1, 10):
  backtracking(s)

if n >= len(set_arr):
  print(-1)
else:
  list_arr = sorted(list(set_arr))
  print(list_arr[n])