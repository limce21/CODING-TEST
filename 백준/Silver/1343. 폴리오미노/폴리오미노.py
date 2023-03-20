import sys

data = list(sys.stdin.readline().rstrip())

count = 0
result = []
for i in data:
  if i == 'X':
    count += 1
    if count == 2:
      result.append('BB')
      count = 0
      continue
  if i == '.':
    if count % 2 == 1:
      result = -1
      break
    else:
      result.append('.')

if result == -1 or len(''.join(result)) != len(data):
  print(-1)
else:
  count = 0
  answer = []
  for i in range(len(result)):
    if result[i] == '.':
      count = 0
      answer.append('.')
    else:
      count += 1
      if count == 2:
        answer.append('AAAA')
        count = 0
      if (count == 1 and i == len(result) - 1) or (count == 1
                                                   and result[i + 1] == '.'):
        answer.append('BB')
        count = 0
  print(''.join(answer))
