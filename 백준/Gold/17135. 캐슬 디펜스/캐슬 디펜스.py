import sys
from itertools import combinations
from collections import deque
import copy
input = sys.stdin.readline

#좌 상 우 순서, 아래는 볼 필요 없음
dx = [0,-1,0]
dy = [-1,0,1]

# 멘해튼거리 계산
def calc_distance(x1,x2,y1,y2):
    return abs(x1-x2) + abs(y1-y2)

# D 거리 안에 있는 사장 가까운 적을 찾음 없다면 False
def find_enemy(col):
    queue = deque()
    queue.append([N-1,col])
    while queue:
        x,y = queue.popleft()
        if calc_distance(N, x, col, y) > D:
            return False
        if board[x][y] == 1:
            return (x,y)
        for i in range(3):
            ax = x + dx[i]
            ay = y + dy[i]
            if 0 <= ax < N and 0 <= ay < M:
                queue.append([ax,ay])

# board에서 모든 적이 한칸 씩 아래로 내려감
def move_enemy():
    for j in range(M):
        for i in range(N-2,-1,-1):
            board[i+1][j] = board[i][j]
    for i in range(M):
        board[0][i] = 0

# 성에 도착한 적을 삭제함
def del_enemy():
    cnt = 0
    for i in range(M):
        if board[N-1][i] == 1:
            cnt += 1
    return cnt

N,M,D = map(int,input().split())
maps = [list(map(int,input().split())) for _ in range(N)]
cnt_enemy = 0 # 처음 적의 수 
answer = 0
for i in range(N):
    for j in range(M):
        if maps[i][j] == 1:
            cnt_enemy += 1

# 0~M-1의 수 중 3개씩 뽑은 모든 조합에 대해 탐색
for comb in combinations(list(range(M)),3):
    del_cnt = 0
    curr_enemy = cnt_enemy
    board = copy.deepcopy(maps)
    # 남아있는 적이 있는 동안 게임 진행
    while curr_enemy > 0:
        tmp = set()
        for i in comb: # 궁수의 위치에서 쏠 수 있는 적을 찾음
            enemy_pos = find_enemy(i)
            if enemy_pos: 
                tmp.add(enemy_pos)
                
        for x,y in tmp: # 궁수가 쏠 수 있는 적을 쏨
            board[x][y] = 0
            
        del_cnt += len(tmp) # 삭제한 적의 수 카운트
        curr_enemy -= len(tmp) # 남은 적의 수 카운트
        curr_enemy -= del_enemy() # 남은 적의 수 카운트
        move_enemy() # 적을 한 칸씩 아래로 내림
    answer = max(answer,del_cnt) # 가장 많은 적을 잡은 경우로 갱신
print(answer)