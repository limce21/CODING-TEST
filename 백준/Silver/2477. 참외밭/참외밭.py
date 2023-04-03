import sys

k = int(sys.stdin.readline().rstrip())
data = []
max_width = 0
max_height = 0

for _ in range(6):
  dir, _len = map(int, sys.stdin.readline().rstrip().split())
  data.append((dir, _len))
  if dir == 1 or dir == 2:
    max_width = max(max_width, _len)
  else:
    max_height = max(max_height, _len)

result = max_width * max_height
for i in range(6):
  if data[i % 6][0] == data[(i + 2) % 6][0] and data[(i + 1) %
                                                     6][0] == data[(i + 3) %
                                                                   6][0]:
    result -= data[(i + 1) % 6][1] * data[(i + 2) % 6][1]

print(result * k)
