import sys

keyboard = {
  'a': (1, 0, 'l'),
  'b': (2, 4, 'r'),
  'c': (2, 2, 'l'),
  'd': (1, 2, 'l'),
  'e': (0, 2, 'l'),
  'f': (1, 3, 'l'),
  'g': (1, 4, 'l'),
  'h': (1, 5, 'r'),
  'i': (0, 7, 'r'),
  'j': (1, 6, 'r'),
  'k': (1, 7, 'r'),
  'l': (1, 8, 'r'),
  'm': (2, 6, 'r'),
  'n': (2, 5, 'r'),
  'o': (0, 8, 'r'),
  'p': (0, 9, 'r'),
  'q': (0, 0, 'l'),
  'r': (0, 3, 'l'),
  's': (1, 1, 'l'),
  't': (0, 4, 'l'),
  'u': (0, 6, 'r'),
  'v': (2, 3, 'l'),
  'w': (0, 1, 'l'),
  'x': (2, 1, 'l'),
  'y': (0, 5, 'r'),
  'z': (2, 0, 'l')
}

sl, sr = sys.stdin.readline().rstrip().split()
word = list(sys.stdin.readline().rstrip())
result = 0
for i in word:
  i_info = keyboard[i]
  if i_info[2] == 'l':
    result += abs(i_info[0] - keyboard[sl][0]) + abs(i_info[1] -
                                                     keyboard[sl][1])
    sl = i
  elif i_info[2] == 'r':
    result += abs(i_info[0] - keyboard[sr][0]) + abs(i_info[1] -
                                                     keyboard[sr][1])
    sr = i
  result += 1

print(result)
