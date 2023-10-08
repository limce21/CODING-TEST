def solution(clothes):
    hash_map = {}
    for cloth, cloth_type in clothes:
        if cloth_type in hash_map:
            hash_map[cloth_type].append(cloth)
        else:
            hash_map[cloth_type] = [cloth]
    answer = 1
    for k in hash_map.keys():
        answer *= len(hash_map[k]) + 1
    answer -= 1
    return answer