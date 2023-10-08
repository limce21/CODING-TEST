def solution(nums):
    answer = 0
    max_size = len(nums) // 2
    nums_set = set(nums)
    set_size = len(nums_set)
    if set_size >= max_size:
        answer = max_size
    else:
        answer = set_size
    return answer