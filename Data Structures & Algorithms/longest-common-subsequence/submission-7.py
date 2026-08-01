

class Solution:
    def longestCommonSubsequence(self, s: str, t: str) -> int:
        n = len(s)
        m = len(t)
        memo = [[-1] * m for _ in range(n)]
        def dfs(i, j):
            if i < 0 or j < 0:
                return 0
            if memo[i][j] != -1:
                return memo[i][j]    
            if s[i] == t[j]:
                ans = dfs(i-1, j-1) + 1
                memo[i][j] = ans
                return memo[i][j]
            ans = max(dfs(i-1,j), dfs(i, j-1))
            memo[i][j] = ans    
            return memo[i][j]

        return dfs(n-1, m-1)        
