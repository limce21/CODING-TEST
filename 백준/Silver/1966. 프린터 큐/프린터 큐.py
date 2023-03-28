import sys
T = int(sys.stdin.readline())

# 값이 같을 때 제대로 안 나옴!
for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    qu = list(map(int, sys.stdin.readline().split()))
    lst = [0] * N
    lst[M] = 1

    while len(qu) > 0:
        if qu[0] == max(qu):
            if lst[0] == 1:
                print(N - len(qu) + 1)
                break
            x = qu.pop(0)
            lst.pop(0)
        else:
            qu.append(qu.pop(0))
            lst.append(lst.pop(0))