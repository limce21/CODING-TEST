import sys

n = int(sys.stdin.readline())
cnt = 0
for _ in range(n):
  word = sys.stdin.readline().rstrip()
  word_dict = {}
  for i in range(len(word)):
    if word[i] in word_dict:
      if i > word_dict[word[i]] + 1:
        cnt += 1
        break
      else:
        word_dict[word[i]] = i
    else:
      word_dict[word[i]] = i

print(n - cnt)
