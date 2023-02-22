import sys
from bisect import bisect_left


def binary_search(a, value):
  index = bisect_left(a, value)
  return index


n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))

data.sort()
result = []
count = 0

for i in range(n):
  index = binary_search(data, -data[i])
  if data[i] > 0:
    if data[i] == data[index]:
      continue
    else:
      result.append((data[i], data[index]))
  else:
    if data[i] == data[index - 1]:
      continue
    else:
      result.append((data[i], data[index - 1]))

result.sort(key=lambda x: abs(x[0] + x[1]))
answer = list(result[0])
answer.sort()
print(answer[0], answer[1])
