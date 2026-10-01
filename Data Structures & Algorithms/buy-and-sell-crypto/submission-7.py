class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        minPrice = float('inf')
        
        for p in prices:
            minPrice = min(minPrice, p)
            profit = max(profit, p - minPrice)

        return profit    




            
        