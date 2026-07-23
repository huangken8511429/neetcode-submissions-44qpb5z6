class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [-1] * (n+1)
        memo[0] = 1
        memo[1] = 1

        def dfs(n):
            if memo[n] != -1:
                return memo[n]
            ans = dfs(n-2) + dfs(n-1)
            memo[n] = ans    
            return memo[n] 

        return dfs(n)    
