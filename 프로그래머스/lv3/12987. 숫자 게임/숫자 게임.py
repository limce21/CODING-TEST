from collections import deque
def solution(A, B):
    answer = -1
    A.sort(reverse=True)
    B.sort(reverse=True)
    a_queue = deque(A)
    b_queue = deque(B)
    
    while b_queue:
        va = a_queue.popleft()
        vb = b_queue.popleft()
        if vb > va:
            answer+= 1
        else:
            b_queue.appendleft(vb)
            b_queue.pop()
            
            
    
    
    
    return answer + 1