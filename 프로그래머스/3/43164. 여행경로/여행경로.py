n = 0
di = dict()
visited = dict()
answer = []

def compare(l1, l2):
    for i in range(len(l1)):
        if l1[i] == l2[i]:
            continue
        elif l1[i] > l2[i]:
            return True
        else:
            return False 
    return False

def dfs(v, arr):
    global flag, answer
    if len(arr) == n+1:
        if not answer:
            answer = arr
        elif compare(answer, arr):
            answer = arr
        return
    if v not in di:
        return
    for nv in di[v]:
        if visited[(v, nv)] > 0:
            visited[(v, nv)] -= 1
            dfs(nv, arr + [nv])
            visited[(v, nv)] += 1

def solution(tickets):
    global answer, n, visited

    n = len(tickets)

    for s, d in tickets:
        if s in di:
            di[s].append(d)
        else:
            di[s] = [d]
        if (s,d) in visited:
            visited[(s,d)] += 1
        else:
            visited[(s,d)] = 1

    dfs("ICN", ["ICN"])
    
    
    return answer