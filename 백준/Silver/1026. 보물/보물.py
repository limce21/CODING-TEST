import sys
input = sys.stdin.readline

data = []
n = int(input())
for _ in range(2):
  data.append(list(map(int, input().split())))
answer = 0
data[0].sort()
data[1].sort(reverse=True)

for i in range(n):
  answer += data[0][i] * data[1][i]

print(answer)