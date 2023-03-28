import sys

s = list(sys.stdin.readline().rstrip())

flag = False
data = []
normal = []
reverse = []
for i in s:
  if i == '<':
    if len(reverse) != 0:
      data.append(''.join(reverse[::-1]))
      reverse = []
    data.append(i)
    flag = True
    continue
  elif i == '>':
    data.append(''.join(normal))
    normal = []
    data.append(i)
    flag = False
    continue
  else:
    if flag:
      normal.append(i)
    else:
      if i == ' ':
        data.append(''.join(reverse[::-1]))
        data.append(' ')
        reverse = []
      else:
        reverse.append(i)

if len(reverse) != 0:
  data.append(''.join(reverse[::-1]))

print(''.join(data))
