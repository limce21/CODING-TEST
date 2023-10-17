import math

T = int(input())

for _ in range(T):
  x, y = map(int, input().split())
  distance = y - x
  count = 0

  num = math.floor(math.sqrt(distance))  # n제곱 <= 거리 < (n+1)제곱일때 n제곱
  num_square = num**2  # n제곱의 제곱
  increase_num = math.sqrt(num_square)

  if distance > num_square + increase_num:
    count = 2 * num + 1
  elif distance > num_square and distance <= num_square + increase_num:
    count = 2 * num
  elif distance == num_square:
    count = 2 * num - 1

  if distance < 4:
    count = distance

  print(count)
