class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for i, p in enumerate(prices):
            right = i + 1
            while right < len(prices):
                if prices[right] > p:
                    profit = max(profit, prices[right] - p)
                right += 1    
        return profit    
        