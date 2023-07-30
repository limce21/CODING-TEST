import sys

g = int(sys.stdin.readline())

now = 2
rem = 1
answer = []

while True:
  if now ** 2 - (now - 1) ** 2 > 100000:
    break
  sub = now ** 2 - rem ** 2
  if sub < g:
    now += 1
    continue
  elif sub > g:
    rem += 1
    continue
  elif sub == g:
    answer.append(now)
    now += 1
    continue

if answer:
  for i in answer:
    print(i)
else:
  print(-1)
