import heapq
def solution(operations):
    heap = []
    for operation in operations:
        cmd, value = operation.split()
        if cmd == "I":
            heapq.heappush(heap, int(value))
        if cmd == 'D' and len(heap) != 0:
            if value == "1":
                heap.pop()
            else:
                heapq.heappop(heap)
    answer = []
    heap.sort()
    if len(heap) == 0:
        answer = [0, 0]
    else:
        answer = [heap[-1], heap[0]]

    return answer