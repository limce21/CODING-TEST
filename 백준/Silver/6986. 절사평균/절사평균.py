import sys

input = sys.stdin.readline
n, k = map(int, input().split())
scores = []
for _ in range(n):
  scores.append(float(input()))

scores.sort()
scores_cut = scores[k:n - k]
trimmed_average = '{:.2f}'.format(round(sum(scores_cut) / len(scores_cut)+ 1e-8, 2))
print(trimmed_average)

calibrated_list = scores
shortest_score = scores_cut[0]
largest_score = scores_cut[-1]
for i in range(k):
  calibrated_list[i] = shortest_score
for i in range(k):
  calibrated_list[-i-1] = largest_score
calibrated_average = '{:.2f}'.format(round(sum(calibrated_list) / n+ 1e-8, 2))
print(calibrated_average)