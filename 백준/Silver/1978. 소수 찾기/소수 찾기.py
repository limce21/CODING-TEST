import sys
import math


def is_prime_number(x):
  for i in range(2, int(math.sqrt(x)) + 1):
    if x % i == 0:
      return False
  return True


n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
result = 0
for i in data:
  if i != 1 and is_prime_number(i):
    result += 1

print(result)