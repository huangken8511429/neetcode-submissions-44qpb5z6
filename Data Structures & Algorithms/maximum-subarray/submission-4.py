from functools import cache
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # 前綴和
        # ans = float('-inf')
        # min_pre_sum = pre_sum = 0
        # for x in nums:
        #     pre_sum += x
        #     ans = max(ans, pre_sum - min_pre_sum)
        #     min_pre_sum = min(min_pre_sum, pre_sum)
        # return ans

        # DP
        ans = float('-inf') 
        f = 0
        for x in nums:
            f = max(f, 0) + x
            ans = max(ans, f)
        return ans    