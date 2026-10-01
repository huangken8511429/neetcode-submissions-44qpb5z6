class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        minPrice = float('inf')
        
        for p in prices:
            profit = max(profit, p - minPrice)
            minPrice = min(minPrice, p)

        return profit    




            
        