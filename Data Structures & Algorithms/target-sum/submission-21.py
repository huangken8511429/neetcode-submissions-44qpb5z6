from functools import cache
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums) 
        target += sum(nums) 
        if target % 2 != 0:
            return 0
        target //= 2
        f = [0] * (target+1)
        f[0] = 1
        # f[i][c] = f[i-1][c] + f[i-1][c - nums[i]]
        # f[c] = f[c] + f[c-nums[i]]
        for x in nums:
            for c in range(target, x-1, -1):
                f[c] = f[c] + f[c - x]
        return f[target]         
        # @cache
        # def dfs(i, c):
        #     if i < 0:
        #         return 1 if c == 0 else 0
        #     if c < nums[i]:
        #         return dfs(i-1, c)
        #     return dfs(i-1, c) + dfs(i-1, c - nums[i])

        # return dfs(n-1, target)                

