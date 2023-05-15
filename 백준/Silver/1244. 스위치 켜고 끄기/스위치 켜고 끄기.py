import sys

input = sys.stdin.readline


def switch_light(num):
  if num == 1:
    return 0
  else:
    return 1


switch_num = int(input())
switch_list = list(map(int, input().split()))
student_num = int(input())

for _ in range(student_num):
  sex, num = map(int, input().split())
  if sex == 1:
    for i in range(switch_num // num):
      index = num + i * num - 1
      switch_list[index] = switch_light(switch_list[index])
  else:
    switch_list[num - 1] = switch_light(switch_list[num - 1])
    index = 1
    while num - 1 - index >= 0 and num - 1 + index < switch_num:
      if switch_list[num - 1 - index] == switch_list[num - 1 + index]:
        switch_list[num - 1 - index] = switch_light(switch_list[num - 1 -
                                                                index])
        switch_list[num - 1 + index] = switch_list[num - 1 - index]
        index += 1
      else:
        break

result = [switch_list[i:i + 20] for i in range(0, switch_num, 20)]
for i in result:
  print(*i)