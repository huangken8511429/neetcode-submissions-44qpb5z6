class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = [-1] * n

        def dfs(i):
            if i < 0:
                return 0
            if memo[i] != -1:
                return memo[i]    
            res = max(dfs(i-1), dfs(i-2) + nums[i])
            memo[i] = res
            return res

        return dfs(n-1)    