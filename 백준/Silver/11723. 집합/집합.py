import sys

m = int(sys.stdin.readline().rstrip())
data = set()

for _ in range(m):
  string = sys.stdin.readline().rstrip()
  if string == 'all':
    data = set([i + 1 for i in range(20)])
    continue
  elif string == 'empty':
    data = set([])
    continue
  else:
    command, value = string.split()
    value = int(value)
    if command == 'add':
      data.add(value)
    elif command == 'remove':
      data_list = str(data)
      if data_list.find(str(value)) != -1:
        data.remove(value)
    elif command == 'check':
      data_list = str(data)
      if data_list.find(str(value)) != -1:
        print(1)
      else:
        print(0)
    elif command == 'toggle':
      data_list = str(data)
      if data_list.find(str(value)) != -1:
        data.remove(value)
      else:
        data.add(value)
