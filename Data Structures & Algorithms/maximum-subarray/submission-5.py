class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        min_pre_sum = pre_sum = 0
        ans = float('-inf')

        for n in nums:
            pre_sum += n
            ans = max(ans, pre_sum - min_pre_sum)
            min_pre_sum = min(min_pre_sum, pre_sum)
        return ans    
            