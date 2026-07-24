class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        f_max = 1
        f_min = 1

        ans = float('-inf')
        
        # f[i] = max(f[i-1], 0) + x
        # f[i] = max(f[i-1] * x, x)
        for x in nums:
            f_max, f_min = max(f_max * x, f_min * x, x), min(f_max * x, f_min * x, x)
            ans = max(ans, f_max)
        return ans