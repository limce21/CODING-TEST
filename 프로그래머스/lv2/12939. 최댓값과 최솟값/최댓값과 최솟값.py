def solution(s):
    s_list = s.split()
    s_list = list(map(int, s_list))
    answer = str(min(s_list)) + " " + str(max(s_list))
    return answer