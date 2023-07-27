import sys

input = sys.stdin.readline

n, m = map(int, input().split())
a = []
for _ in range(n):
  a.append(int(input()))

a.sort()
end = 0
answer = int(2e9)
for start in a:
  sub = 0
  while end < n:
    sub = abs(a[end] - start)
    if sub >= m:
      answer = min(answer, sub)
      break
    end += 1

print(answer)