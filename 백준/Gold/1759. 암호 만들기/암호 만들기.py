import sys


def is_mo(alpha):
  if alpha == 'a' or alpha == 'e' or alpha == 'i' or alpha == 'o' or alpha == 'u':
    return True
  return False


def combinations(idx, mo_cnt, ja_cnt, arr):
  if len(arr) == l and mo_cnt >= 1 and ja_cnt >= 2:
    print(''.join(arr))
    return
  for i in range(idx, c):
    arr.append(data[i])
    if is_mo(data[i]):
      combinations(i + 1, mo_cnt + 1, ja_cnt, arr)
    else:
      combinations(i + 1, mo_cnt, ja_cnt + 1, arr)
    arr.pop()


l, c = map(int, sys.stdin.readline().split())
data = list(sys.stdin.readline().rstrip().split())
data.sort()
combinations(0, 0, 0, [])
