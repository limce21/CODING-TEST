import sys


def z(r, c, n, value):
  if n == 2:
    if r == 0 and c == 0:
      print(value)
    elif r == 0 and c == 1:
      print(value+1)
    elif r == 1 and c == 0:
      print(value+2)
    else:
      print(value+3)
    return
  if r < n // 2 and c < n // 2:
    z(r % (n // 2), c % (n // 2), n // 2, value)
  elif r < n // 2 and c >= n // 2:
    z(r % (n // 2), c % (n // 2), n // 2, value + (n // 2)**2)
  elif r >= n // 2 and c < n // 2:
    z(r % (n // 2), c % (n // 2), n // 2, value + 2 * ((n // 2)**2))
  else:
    z(r % (n // 2), c % (n // 2), n // 2, value + 3 * ((n // 2)**2))


n, r, c = map(int, sys.stdin.readline().split())
n = 2**n

z(r, c, n, 0)
