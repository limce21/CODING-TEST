import sys

s = list(sys.stdin.readline().rstrip())
s = list(map(int, s))

zero_result = 0
one_result = 0

for i in range(len(s) - 1):
  if s[i] == 1:
    if s[i + 1] != 1:
      one_result += 1
  else:
    if s[i + 1] != 0:
      zero_result += 1

if s[-1] == 0:
  zero_result += 1
else:
  one_result += 1

print(min(one_result, zero_result))
