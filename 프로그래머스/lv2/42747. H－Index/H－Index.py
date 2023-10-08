def solution(citations):
    answer = 0
    for i in range(max(citations)+1):
        h = 0
        for citation in citations:
            if citation >= i:
                h += 1
        if h >= i:
            answer = max(answer, i)
    return answer