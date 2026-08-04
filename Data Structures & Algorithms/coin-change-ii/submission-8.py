from functools import cache
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        f = [0] * (amount + 1)
        f[0] = 1

        # x = 1
        # c = 1

        for x in coins:
            for c in range(x, amount+1):
                f[c] += f[c - x]
        return f[amount]        

            #    f[c] = f[c] + f[c - coins[i]] 
        # @cache
        # def dfs(i, c):
        #     if i < 0:
        #         return 1 if c == 0 else 0
        #     if c < coins[i]:
        #         return dfs(i-1, c)
        #     return dfs(i-1, c) + dfs(i, c - coins[i])

        return dfs(n-1, amount)           