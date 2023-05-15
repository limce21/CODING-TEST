import sys, copy
input = sys.stdin.readline
people, message, checkingMessage = map(int, input().split())
whoRead = [{'A'} for _ in range(message)]
notReadCount = []
for i in range(message):
    notRead, sender = input().split()
    notReadCount.append(int(notRead))

    # 보낸 사람이 A가 아니면 내가 메세지를 보내기 위해서 앞의 모든 메세지를 읽었어야 하므로 앞에 읽은 모든 메세지에 나를 추가
    if sender != 'A':
        for j in range(0, i):
            whoRead[j].add(sender)

    # 읽지 않은 사람의 숫자가 그대로라면, 직전 상태와 현재 상태가 같다는 의미이다.
    if i > 0 and notReadCount[i] == notReadCount[i-1]:
        whoRead[i] = copy.deepcopy(whoRead[i-1])

    # 현재 메세지를 읽은 사람에 나를 추가
    whoRead[i].add(sender)


if notReadCount[checkingMessage-1] == 0:
    print(-1)
else:
    for i in range(people):
        if chr(ord('A') + i) not in whoRead[checkingMessage-1]:
            print(chr(ord('A') + i), end=' ')