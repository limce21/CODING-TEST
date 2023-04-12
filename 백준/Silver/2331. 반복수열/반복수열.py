import sys

a, p = map(int, sys.stdin.readline().rstrip().split())


def next(v):
  global p
  v_list = list(str(v))
  result = 0
  for i in v_list:
    result += int(i)**p
  return result


data = [a]
result = 0
while 1:
  value = next(a)
  if value in data:
    result = data.index(value)
    break
  data.append(value)
  a = value

print(result)