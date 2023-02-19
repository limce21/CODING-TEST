import sys


def fibo(x):
  if x == 0:
    return 1
  if x == 1:
    return 1
  if dp[x] != 0:
    return dp[x]
  dp[x] = fibo(x - 1) + fibo(x - 2)
  count[x] = (count[x-1][0] + count[x-2][0], count[x-1][1] + count[x-2][1])
  return dp[x]

t = int(sys.stdin.readline().rstrip())
count = [(0,0) for _ in range(41)]
count[0] = (1,0)
count[1] = (0,1)
dp = [0] * 41

for _ in range(t):
  n = int(sys.stdin.readline().rstrip())
  fibo(n)
  zero, one = count[n]
  print(zero, one)