import sys

data = sys.stdin.readline().rstrip()

zero_arr = []
one_arr = []

result = 0
count = 1

for i in range(len(data)-1):
  if data[i] != data[i + 1]:
    if data[i] == '0':
      zero_arr.append(count)
    else:
      one_arr.append(count)
    count = 1
  else:
    count += 1

if data[len(data)-1] == '0':
  zero_arr.append(count)
else:
  one_arr.append(count)

if len(zero_arr) > len(one_arr):
  result = len(one_arr)
else:
  result = len(zero_arr)
print(result)
