import sys
from collections import Counter


def sequence():
  cnt = 0
  for i in range(4):
    if num_list[i] + 1 == num_list[i + 1]:
      cnt += 1
  return cnt


color_list = []
num_list = []

for _ in range(5):
  color, num = sys.stdin.readline().rstrip().split()
  color_list.append(color)
  num_list.append(int(num))

color_counter = list(Counter(color_list).items())
num_counter = list(Counter(num_list).items())
num_counter.sort(key=lambda x: (-x[1], -x[0]))

num_list.sort()
cnt = sequence()

if len(color_counter) == 1:
  num_list.sort()
  if cnt == 4:
    print(num_list[-1] + 900)
  else:
    print(num_list[-1] + 600)
elif cnt == 4:
  print(num_list[-1] + 500)
elif len(num_counter) == 2:
  if num_counter[0][1] == 4:
    print(num_counter[0][0] + 800)
  else:
    print(num_counter[0][0] * 10 + num_counter[1][0] + 700)
elif len(num_counter) == 3:
  if num_counter[0][1] == 3:
    print(num_counter[0][0] + 400)
  else:
    print(num_counter[0][0] * 10 + num_counter[1][0] + 300)
elif len(num_counter) == 4:
  print(num_counter[0][0] + 200)
else:
  print(num_counter[0][0] + 100)
