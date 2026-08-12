from functools import cache

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        f = nums[0]
        ans = nums[0]

        for i in range(1, n):
            f = max(f, 0) + nums[i]
            ans = max(ans, f)
        return ans

        # min_pre_sum = pre_sum = 0
        # ans = float('-inf')

        # for n in nums:
        #     pre_sum += n
        #     ans = max(ans, pre_sum - min_pre_sum)
        #     min_pre_sum = min(min_pre_sum, pre_sum)
        # return ans    
                    
            