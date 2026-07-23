class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        memo = [-1] * (n + 1)

        def dfs(i):
            if (memo[i] != -1):
                return memo[i]
            if i == 0 or i == 1:
                return 0
            ans = min(cost[i-1] + dfs(i-1), cost[i-2] + dfs(i-2))
            memo[i] = ans    
            return memo[i]

        return dfs(n)    