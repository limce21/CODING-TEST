import sys

names = list(sys.stdin.readline().rstrip())
name_cnt = [0 for _ in range(26)]
for name in names:
  name_cnt[ord(name) - 65] += 1

odd = 0
odd_answer = ""
answer = ""
for i in range(26):
  if name_cnt[i] % 2 == 1:
    odd += 1
    odd_answer += chr(i + 65)
  answer += chr(i + 65) * (name_cnt[i] // 2)

if odd > 1:
  print("I'm Sorry Hansoo")
else:
  print(answer + odd_answer + answer[::-1])