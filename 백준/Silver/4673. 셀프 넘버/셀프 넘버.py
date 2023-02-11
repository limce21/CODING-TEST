data_set = set([])

for i in range(1, 10001):
  summ = i
  for j in str(i):
    summ += int(j)
  data_set.add(summ)
  
result = [i for i in range(1, 10001) if i not in data_set]

for i in result:
  print(i)