class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        # f[i] = (f[i-1], f[i-2] + nums[i])
        # f[i+2] = f[i+1], f[i] + nums[i]
        f0 = 0
        f1 = 0
        for i in range(n):
            tmp = max(f1, f0 + nums[i])
            f0 = f1
            f1 = tmp
        return f1    