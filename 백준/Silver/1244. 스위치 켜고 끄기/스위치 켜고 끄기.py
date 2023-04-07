import sys

input = sys.stdin.readline


def zero_one(value):
  if value == 0:
    return 1
  else:
    return 0


switch_n = int(input())
switches = list(map(int, input().split()))

student_n = int(input())
students = []

for i in range(student_n):
  students.append((map(int, input().split())))

for student in students:
  sex, num = student
  if sex == 1:
    for i in range(1, switch_n // num + 1):
      switches[i * num - 1] = zero_one(switches[i * num - 1])
  else:
    switches[num - 1] = zero_one(switches[num - 1])
    for i in range(1, num):
      if num - 1 - i >= 0 and num - 1 + i < switch_n and switches[
          num - 1 - i] == switches[num - 1 + i]:
        switches[num - 1 - i] = zero_one(switches[num - 1 - i])
        switches[num - 1 + i] = zero_one(switches[num - 1 + i])
      else:
        break

if switch_n >= 20:
  for i in range((switch_n - 1) // 20 + 1):
    if switch_n > 20 * (i + 1):
      slice_list = switches[i * 20:(i + 1) * 20]
    else:
      slice_list = switches[i * 20:]
    print(' '.join(map(str, slice_list)))
else:
  print(' '.join(map(str, switches)))
