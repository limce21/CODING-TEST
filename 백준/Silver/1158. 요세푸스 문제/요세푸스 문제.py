import sys
N, K = map(int, sys.stdin.readline().split())

lst = list(range(1, N+1))
pop_list = []

while len(lst) > 1:
    if K <= len(lst):
        pop_list.append(lst.pop(K-1))
        lst = lst[K-1:] + lst[:K-1]
    else:
        i = K %len(lst)
        pop_list.append(lst.pop(i-1))
        if i != 0:
          lst = lst[i-1:] + lst[:i-1]       
        
pop_list.append(lst.pop())
print("<"+str(pop_list)[1:-1]+">")