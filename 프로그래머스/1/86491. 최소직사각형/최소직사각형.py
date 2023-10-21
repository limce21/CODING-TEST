def calc(s):
    w = [i[0] for i in s]
    h = [i[1] for i in s]
    return max(w) * max(h)


def solution(sizes):
    answer = 0
    for s in sizes:
        if s[0] < s[1]:
            tmp = s[0]
            s[0] = s[1]
            s[1] = tmp
    answer = calc(sizes)
    return answer