import sys
from itertools import permutations

n = int(sys.stdin.readline().rstrip())
words = []

for _ in range(n):
  arr = list(sys.stdin.readline().rstrip())
  words.append(arr)

arr = list(permutations(words[0], len(words[0])))
data = list(map(lambda x: ''.join(x), arr))
arr = list(permutations(words[0], len(words[0]) - 1))
data += (list(map(lambda x: ''.join(x), arr)))

cnt = 0
for i in words[1:]:
  word = ''.join(i)
  if word in data:
    cnt += 1
    continue
  for j in range(len(i)):
    value = i[:j] + i[j + 1:]
    if ''.join(value) in data:
      cnt += 1
      break

print(cnt)
