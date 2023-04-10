import sys


def calc_xy(s):
  arr = list(s)
  y = ord(arr[0]) - 65
  x = int(arr[1]) - 1
  return x, y


king_pos, rock_pos, n = sys.stdin.readline().rstrip().split()
king_pos = tuple(calc_xy(king_pos))
rock_pos = tuple(calc_xy(rock_pos))

move_dir = {
  'R': (0, 1),
  'L': (0, -1),
  'B': (-1, 0),
  'T': (1, 0),
  'RT': (1, 1),
  'LT': (1, -1),
  'RB': (-1, 1),
  'LB': (-1, -1)
}

for _ in range(int(n)):
  move = sys.stdin.readline().rstrip()
  dir_x, dir_y = move_dir[move]
  kx, ky = king_pos
  rx, ry = rock_pos
  nkx, nky = dir_x + kx, dir_y + ky
  nrx, nry = dir_x + rx, dir_y + ry

  if nkx < 0 or nkx >= 8 or nky < 0 or nky >= 8:
    continue
  if nkx == rx and nky == ry:
    if nrx < 0 or nrx >= 8 or nry < 0 or nry >= 8:
      continue
    else:
      king_pos = (nkx, nky)
      rock_pos = (nrx, nry)
  else:
    king_pos = (nkx, nky)

kx, ky = king_pos
kx = kx + 1
ky = chr(ky + 65)
print(ky + str(kx))

rx, ry = rock_pos
rx = rx + 1
ry = chr(ry + 65)
print(ry + str(rx))
