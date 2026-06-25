class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        ans = right

        while left <= right:   
            totalTime = 0
            mid = (left + right) // 2
            for p in piles:
                totalTime += math.ceil(p / mid)
            if totalTime <= h:
                ans = mid
                right = mid - 1
            else:
                left = mid + 1        
        return ans                       