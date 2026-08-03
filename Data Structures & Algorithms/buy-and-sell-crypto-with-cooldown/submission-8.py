class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        memo = [[None] * 2 for _ in range(n)]
        def dfs(i, hold):
            if i < 0:
                return float('-inf') if hold else 0
            if memo[i][hold]:
                return memo[i][hold]    
            if hold:
                memo[i][hold] = max(dfs(i-1, True), dfs(i-2, False) - prices[i])
                return memo[i][hold]
            memo[i][hold] = max(dfs(i-1, False), dfs(i-1, True) + prices[i])
            return memo[i][hold]

        return dfs(n-1, False)    