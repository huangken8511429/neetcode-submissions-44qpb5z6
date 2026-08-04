
class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
      # f[i][0] 兩天前空手, f[i+1][1] 前一天持有, f[i+1][0] 前一天空手
        pre0, hold, free = 0, float('-inf'), 0 
        for p in prices:
            pre0, hold, free = free, max(hold, pre0 - p), max(free, hold + p)
        return free

        # for i in range(n):
        #     for j in range(2):
        #         if j == 1:
        #             f[i+2][j] = max(f[i+1][j], f[i][0] - prices[i])
        #         else:
        #             f[i+2][j] = max(f[i+1][j], f[i+1][1] + prices[i])
        # return f[n+1][0]                

        # @cache
        # def dfs(i, hold):
        #     if i < 0:
        #         return float('-inf') if hold else 0
        #     if hold:
        #         return max(dfs(i-1, True), dfs(i-2, False) - prices[i])
        #     return max(dfs(i-1, False), dfs(i-1, True) + prices[i])

        # return dfs(n-1, False)            