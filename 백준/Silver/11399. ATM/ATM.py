import sys

n = int(sys.stdin.readline().rstrip())
data = list(map(int, sys.stdin.readline().rstrip().split()))
data.sort()

result = 0

for i in range(len(data)):
    result += data[i] * (len(data) - i)

print(result)