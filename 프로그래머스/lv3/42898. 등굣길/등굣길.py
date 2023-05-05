def solution(m, n, puddles):
    dp = [[0] * m for _ in range(n)]
    for puddle in puddles:
        x, y = puddle
        dp[y-1][x-1] = -1
    
    dp[0][0] = 1
    
    for x in range(n):
        for y in range(m):
            if dp[x][y] == -1:
                continue
            if x >= 1 and dp[x-1][y] != -1:
                dp[x][y] += dp[x-1][y]
            if y >= 1 and dp[x][y-1] != -1:
                dp[x][y] += dp[x][y-1]
                
    answer = dp[n-1][m-1] % 1000000007
    return answer