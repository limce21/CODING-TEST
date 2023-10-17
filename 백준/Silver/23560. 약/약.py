import sys

input = sys.stdin.readline
n = int(input())

answer = 2 * (3 ** (n-1))
print(answer)