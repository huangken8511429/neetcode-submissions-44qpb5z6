
class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)

        f = [[0] * 2 for _ in range(n + 2)]
        f[0][1] = f[1][1] = float('-inf')
        
        for i in range(n):
            for j in range(2):
                if j == 1:
                    f[i+2][j] = max(f[i+1][j], f[i][0] - prices[i])
                else:
                    f[i+2][j] = max(f[i+1][j], f[i+1][1] + prices[i])
        return f[n+1][0]                

        # @cache
        # def dfs(i, hold):
        #     if i < 0:
        #         return float('-inf') if hold else 0
        #     if hold:
        #         return max(dfs(i-1, True), dfs(i-2, False) - prices[i])
        #     return max(dfs(i-1, False), dfs(i-1, True) + prices[i])

        # return dfs(n-1, False)            