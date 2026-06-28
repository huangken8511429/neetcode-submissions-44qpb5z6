class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_price = 101
        for p in prices:
            min_price = min(min_price, p)
            profit = max(profit, p - min_price)
        return profit    
            
        