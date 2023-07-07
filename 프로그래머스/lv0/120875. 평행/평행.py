from itertools import combinations

def solution(dots):
    answer = 0
    combs = list(combinations(dots, 2))
    for i in range(3):
        dot1, dot2 = combs[i]
        dot3, dot4 = combs[5-i]
        m1 = (dot2[1] - dot1[1]) / (dot2[0] - dot1[0])
        m2 = (dot4[1] - dot3[1]) / (dot4[0] - dot3[0])
        print(m1, m2)
        if m1 == m2:
            answer = 1
            break
    return answer