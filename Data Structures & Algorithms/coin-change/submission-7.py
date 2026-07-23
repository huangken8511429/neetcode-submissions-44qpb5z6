class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        memo = {}

        def dfs(i, c):
            if i < 0:
                return 0 if c == 0 else float('inf')
            if (i, c) in memo:
                return memo[(i,c)]
            res = float('inf')    
            if c < coins[i]:
                res = dfs(i-1, c)
            else:
                res = min(dfs(i-1, c), dfs(i, c - coins[i]) + 1) 
            memo[(i,c)] = res
            return memo[(i,c)]

        ans = dfs(n-1, amount)
        return ans if ans < float('inf') else -1                    