import sys

n = int(sys.stdin.readline())
result = 1

for i in range(2, n + 1):
  result *= i

data = list(str(result))
cnt = 0
for i in range(len(data) - 1, -1, -1):
  if data[i] == '0':
    cnt += 1
  if data[i] != '0':
    print(cnt)
    break
