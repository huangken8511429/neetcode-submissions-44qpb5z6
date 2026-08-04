from functools import cache
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # sum = p + q
        # q = sum - p
        # p - (sum - p) = target
        # 2p - sum = target
        # 2= target + sum
        # p = target + sum // 2
        n = len(nums) 
        target += sum(nums) 
        if target % 2 != 0:
            return 0
        target //= 2

        @cache
        def dfs(i, c):
            if i < 0:
                return 1 if c == 0 else 0
            if c < nums[i]:
                return dfs(i-1, c)
            return dfs(i-1, c) + dfs(i-1, c - nums[i])

        return dfs(n-1, target)                

