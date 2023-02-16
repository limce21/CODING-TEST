import sys
from collections import Counter

n = int(sys.stdin.readline().rstrip())

data = []
for _ in range(n):
  data.append(int(sys.stdin.readline().rstrip()))

result = round(sum(data) / n)
print(result)

data.sort()
result = data[n // 2]
print(result)

counter = Counter(data)
dict_counter = dict(counter)
max_count = max(dict_counter, key=dict_counter.get)
count_list = []
for i in data:
  if dict_counter[i] == dict_counter[max_count]:
    count_list.append(i)
count_set = set(count_list)
count_list = list(count_set)
count_list.sort()
if len(count_list) > 1:
  result = count_list[1]
else:
  result = count_list[0]
print(result)

max_value = max(data)
min_value = min(data)
result = max_value - min_value
print(result)