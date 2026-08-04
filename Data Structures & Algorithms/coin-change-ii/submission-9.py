from functools import cache
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        f = [0] * (amount + 1)
        f[0] = 1

        for x in coins:
            for c in range(x, amount+1):
                f[c] += f[c - x]
        return f[amount]         