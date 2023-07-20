import sys

input = sys.stdin.readline

n = int(input())
meeting = []
for _ in range(n):
  meeting.append(list(map(int, input().split())))

meeting.sort(key=lambda x: (x[1], x[0]))

st = meeting[0][0]
et = meeting[0][1]
cnt = 1
for i in range(1, n):
  s = meeting[i][0]
  e = meeting[i][1]
  if s >= et:
    cnt += 1
    st = s
    et = e

print(cnt)