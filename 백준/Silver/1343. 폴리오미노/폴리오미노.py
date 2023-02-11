import sys

data = sys.stdin.readline().rstrip().split('.')

result = ""
arr = []

for i in data:
  if i == '':
    arr.append('')
    continue
  if len(i) % 2 == 1:
    result = -1
    break
  n = len(i)
  s = ""
  while n > 0:
    if n >= 4:
      val = n // 4
      n %= 4
      s += ('AAAA' * val)
    else:
      val = n // 2
      n %= 2
      s += ('BB'*val)
  arr.append(s)

if result == -1:
  print(result)
else:
  print(('.').join(arr))