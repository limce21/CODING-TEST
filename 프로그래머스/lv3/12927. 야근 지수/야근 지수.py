import heapq
def solution(n, works):
    answer = 0
    heap = []
    for work in works:
        heapq.heappush(heap, -work)
    for i in range(n):
        temp = heapq.heappop(heap)
        heapq.heappush(heap, temp+1)
    if sum(heap) >= 0:
        answer = 0
    else:
        for work in heap:
            answer += work ** 2
        
    return answer