class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        f_min = 1
        f_max = 1
        ans = float('-inf')

        for x in nums:
            old_max = f_max
            old_min = f_min
            f_max = max(old_max * x, old_min * x, x)
            f_min = min(old_max * x, old_min * x, x)
            ans = max(ans, f_max)
        return ans        
        