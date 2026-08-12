from functools import cache

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        f = [float('-inf')] * (n+1)
        f[0] = nums[0]

        for i in range(1, n):
            f[i] = max(f[i-1], 0) + nums[i]
        return max(f)

        # min_pre_sum = pre_sum = 0
        # ans = float('-inf')

        # for n in nums:
        #     pre_sum += n
        #     ans = max(ans, pre_sum - min_pre_sum)
        #     min_pre_sum = min(min_pre_sum, pre_sum)
        # return ans    
                    
            