import sys

input = sys.stdin.readline

n = int(input())
num = int(input())
data = [[0] * n for _ in range(n)]
x, y = 0, 0
i = 0
cnt = 1

if cnt == num:
  x = n // 2
  y = n // 2
data[n // 2][n // 2] = cnt
cnt += 1

while cnt <= n**2:
  cx = n // 2 - i
  cy = n // 2 - i
  for j in range(2 * i + 2):
    if cnt == num:
      x = cx - 1
      y = cy + j
    data[cx - 1][cy + j] = cnt
    cnt += 1
  for j in range(2 * i + 2):
    if cnt == num:
      x = cx + j
      y = cy + 2 * i + 1
    data[cx + j][cy + 2 * i + 1] = cnt
    cnt += 1
  for j in range(2 * i + 2):
    if cnt == num:
      x = cx + 2 * i + 1
      y = cy + 2 * i - j
    data[cx + 2 * i + 1][cy + 2 * i - j] = cnt
    cnt += 1
  for j in range(2 * i + 2):
    if cnt == num:
      x = cx + 2 * i - j
      y = cy - 1
    data[cx + 2 * i - j][cy - 1] = cnt
    cnt += 1
  i += 1

for i in data:
  print(*i)
print(x + 1, y + 1)
