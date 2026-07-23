class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
       n = len(coins)
       # f[i][c] = min(f[i-1][c], f[i][c - coins[i]]
       # f[c] = min(f[c], f[c-coins[i]])
       f = [float('inf')] * (amount + 1)
       f[0] = 0

       for x in coins:
        for c in range(x, amount + 1):
            f[c] = min(f[c], f[c - x] + 1)

       ans = f[amount]
       return ans if ans < float('inf') else -1     
