import sys
from itertools import combinations_with_replacement

n = int(sys.stdin.readline())
data = [1, 5, 10, 50]
result = set(combinations_with_replacement(data, n))
result = set(map(lambda x: sum(x), result))
print(len(result))