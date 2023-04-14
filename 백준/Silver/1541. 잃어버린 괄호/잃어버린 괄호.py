import sys

expression = sys.stdin.readline().rstrip().split('-')
result = 0
for i in expression[0].split('+'):
  result += int(i)
for i in expression[1:]:
  for j in i.split('+'):
    result -= int(j)

print(result)
