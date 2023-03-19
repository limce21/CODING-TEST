import sys

n = int(sys.stdin.readline().rstrip())

insert_data = []
result = 1

for _ in range(n):
  s, t = map(int, sys.stdin.readline().rstrip().split())
  insert_data.append((s, t))

insert_data.sort(key=lambda x: (x[0], -(x[0] - x[1])))

end_time = [insert_data[0][1]]
for i in range(1, n):
  x, y = insert_data[i]
  flag = -1
  for j in range(len(end_time)):
    if x >= end_time[j]:
      end_time[j] = y
      flag = j
      break
  if flag == -1:
    end_time.append(y)

print(len(end_time))
