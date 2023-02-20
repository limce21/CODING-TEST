import sys

n = int(sys.stdin.readline().rstrip())
data = []
for _ in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

data.sort(reverse=True)
result = 0

for i in range(n):
  result = max(result, data[i] * (i+1))

print(result)