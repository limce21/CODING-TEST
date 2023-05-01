from collections import deque
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    def_lst = list(sys.stdin.readline().strip())
    n = int(sys.stdin.readline())
    n_lst = sys.stdin.readline().strip()[1:-1].split(',')
    queue = deque(n_lst)
    rcnt = 0
    flag = 0
    if n == 0:
        queue = []

    for i in range(len(def_lst)):
        if def_lst[i] == 'R':
            rcnt += 1
        elif def_lst[i] == 'D':
            if queue:
                if rcnt % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
            else:
                flag = 1
                print("error")
                break
    if flag == 0:
        if rcnt % 2 == 1:
            queue.reverse()
        print("[" + ",".join(queue) + "]")
