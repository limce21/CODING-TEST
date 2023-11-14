import sys

input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
  arr.append(list(map(int, input().split())))
arr.sort(key=lambda x: (x[0], x[1]))
fx, fy = arr[0]
temp = [(fx, fy)]
for i in range(1, n):
  x, y = arr[i]
  flag = True
  for i, (s, e) in enumerate(temp):
    if s <= x <= e:
      flag = False
      if y > e:
        temp[i] = (s, y)
      break
  if flag:
    temp.append((x, y))
  temp.sort(key=lambda x: (x[0], x[1]))

answer = 0
for x, y in temp:
  answer += abs(y - x)
print(answer)
