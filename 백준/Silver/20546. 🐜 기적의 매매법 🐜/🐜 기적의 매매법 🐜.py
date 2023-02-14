import sys

money = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))

j_money = money
j_stock = 0
s_money = money
s_stock = 0
plus_cnt = 0
minus_cnt = 0

for day in range(13):
  if j_money >= data[day]:
    j_stock = j_money // data[day]
    j_money = j_money % data[day]
  if day >= 3:
    if data[day - 3] < data[day - 2] and data[day - 2] < data[
        day - 1] and data[day - 1] < data[day]:
      s_money += s_stock * data[day]
      s_stock = 0
    if data[day - 3] > data[day - 2] and data[day - 2] > data[
        day - 1] and data[day - 1] > data[day]:
      s_stock += s_money // data[day]
      s_money = s_money % data[day]

j_money += data[13] * j_stock
s_money += data[13] * s_stock

if j_money > s_money:
  print("BNP")
elif j_money < s_money:
  print("TIMING")
else:
  print("SAMESAME")