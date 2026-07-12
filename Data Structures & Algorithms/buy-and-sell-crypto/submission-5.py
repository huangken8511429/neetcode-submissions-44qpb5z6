class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        min_value = 101
        
        for p in prices:
            min_value = min(min_value, p)
            profit = max(profit, p - min_value)
        return profit    
            
        