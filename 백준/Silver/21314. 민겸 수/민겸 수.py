import sys

data = list(sys.stdin.readline().rstrip())

m_cnt = 0
max_answer = ''
min_answer = ''
for i in data:
  if i == 'M':
    m_cnt += 1
  else:
    if m_cnt == 0:
      max_answer += '5'
      min_answer += '5'
    else:
      min_answer += str((10**m_cnt) + 5)
      max_answer += str((10**m_cnt) * 5)
    m_cnt = 0

if m_cnt != 0:
  max_answer += '1' * (m_cnt)
  min_answer += str(10**(m_cnt-1))

print(max_answer)
print(min_answer)