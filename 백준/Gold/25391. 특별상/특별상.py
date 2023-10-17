import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
score = []
for i in range(n):
  sm, sk = map(int, input().split())
  score.append((sm, sk, i))
m_list = sorted(score, key=lambda x : -x[0])
k_list = sorted(score, key=lambda x : -x[1])
visited = [False] * (n)

answer = 0
cnt = 0
for i in k_list:
  if cnt == k:
    break
  if not visited[i[2]]:
    answer += i[0]
    visited[i[2]] = True
    cnt += 1

cnt = 0
for i in m_list:
  if cnt == m:
    break
  if not visited[i[2]]:
    answer += i[0]
    visited[i[2]] = True
    cnt += 1

print(answer)