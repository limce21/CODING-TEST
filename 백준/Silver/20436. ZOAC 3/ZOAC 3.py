import sys

sl, sr = sys.stdin.readline().rstrip().split()
data = list(sys.stdin.readline().rstrip())
which_hand = {
  'q':('l',0,0),
  'w':('l',0,1),
  'e':('l',0,2),
  'r':('l',0,3),
  't':('l',0,4),
  'a':('l',1,0),
  's':('l',1,1),
  'd':('l',1,2),
  'f':('l',1,3),
  'g':('l',1,4),
  'z':('l',2,0),
  'x':('l',2,1),
  'c':('l',2,2),
  'v':('l',2,3),
  'y':('r',0,5),
  'u':('r',0,6),
  'i':('r',0,7),
  'o':('r',0,8),
  'p':('r',0,9),
  'h':('r',1,5),
  'j':('r',1,6),
  'k':('r',1,7),
  'l':('r',1,8),
  'b':('r',2,4),
  'n':('r',2,5),
  'm':('r',2,6),
}

cnt = 0
for alpha in data:
  if which_hand[alpha][0] == 'l':
    cnt += abs(which_hand[alpha][1] - which_hand[sl][1]) + abs(which_hand[alpha][2] - which_hand[sl][2])
    cnt += 1
    sl = alpha
  else:
    cnt += abs(which_hand[alpha][1] - which_hand[sr][1]) + abs(which_hand[alpha][2] - which_hand[sr][2])
    cnt += 1
    sr = alpha

print(cnt)