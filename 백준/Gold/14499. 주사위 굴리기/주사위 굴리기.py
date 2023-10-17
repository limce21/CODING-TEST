import sys

input = sys.stdin.readline


def turn(cmd):
  a, b, c, d, e, f = dice[1], dice[2], dice[3], dice[4], dice[5], dice[6]
  if cmd == 1:
    dice[1], dice[2], dice[3], dice[4], dice[5], dice[6] = d, b, a, f, e, c
  elif cmd == 2:
    dice[1], dice[2], dice[3], dice[4], dice[5], dice[6] = c, b, f, a, e, d
  elif cmd == 3:
    dice[1], dice[2], dice[3], dice[4], dice[5], dice[6] = e, a, c, d, f, b
  else:
    dice[1], dice[2], dice[3], dice[4], dice[5], dice[6] = b, f, c, d, a, e


n, m, x, y, k = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))

cmds = list(map(int, input().split()))
dice = dict.fromkeys([i for i in range(1, 7)], 0)
d = {1: [0, 1], 2: [0, -1], 3: [-1, 0], 4: [1, 0]}

reverse_dir = {1: 6, 2: 5, 3: 4, 4: 3, 5: 2, 6: 1}

vx = x
vy = y
cur_dice = 1
for cmd in cmds:
  nx = vx + d[cmd][0]
  ny = vy + d[cmd][1]
  if 0 <= nx < n and 0 <= ny < m:
    turn(cmd)
    print(dice[1])
    if graph[nx][ny] == 0:
      graph[nx][ny] = dice[6]
    else:
      dice[6] = graph[nx][ny]
      graph[nx][ny] = 0
    vx = nx
    vy = ny
