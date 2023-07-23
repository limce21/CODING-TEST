import sys

input = sys.stdin.readline

s, k = map(int, input().split())
data = list(map(int, input().split()))

sub_list = []
for i in range(0, s - 1):
  sub_list.append((data[i + 1] - data[i]))

sub_list.sort(reverse=True)
print(sum(sub_list[k - 1:]))