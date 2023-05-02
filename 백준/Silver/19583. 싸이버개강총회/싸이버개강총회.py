import sys
from datetime import datetime

S, E, Q = sys.stdin.readline().rstrip().split()
chats = []
while 1:
  try:
    time, nickname = sys.stdin.readline().rstrip().split()
    chats.append((time, nickname))
  except:
    break

datetime_format = "%H:%M"
start_time = datetime.strptime(S, datetime_format)
end_time = datetime.strptime(E, datetime_format)
quit_time = datetime.strptime(Q, datetime_format)

chat_dir = {}
result = set()
for chat in chats:
  time, nickname = chat
  time = datetime.strptime(time, datetime_format)
  if time <= start_time:
    chat_dir[nickname] = True
  else:
    if nickname in chat_dir:
      if time >= end_time and time <= quit_time:
        result.add(nickname)
    else:
      continue

print(len(result))