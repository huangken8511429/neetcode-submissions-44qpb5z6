from functools import cache
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)

        @cache
        def dfs(i, c):
            if i < 0:
                return 0 if c == 0 else float('inf')

            if c >= coins[i]:
                return min(dfs(i-1, c), dfs(i, c-coins[i]) + 1)

            return dfs(i-1, c)

        ans = dfs(n-1, amount)

        return ans if ans < float('inf') else -1              
