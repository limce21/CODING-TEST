import sys

n = int(sys.stdin.readline().rstrip())
n_list = list(str(n))

result = 0
sub = n
for i in range(len(n_list)):
  if n >= 10**(i + 1):
    result += 9 * (10**i) * (i + 1)
    sub -= 9 * (10**i)
  else:
    result += sub * (i + 1)

print(result)