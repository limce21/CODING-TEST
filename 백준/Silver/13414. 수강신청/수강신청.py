import sys

k, l = map(int, sys.stdin.readline().split())
wait_dict = {}

for i in range(l):
  student_id = sys.stdin.readline().rstrip()
  wait_dict[student_id] = i

wait_list = sorted(wait_dict.items(), key=lambda x: x[1])
for i in wait_list[:k]:
  print(i[0])