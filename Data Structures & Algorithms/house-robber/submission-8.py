class Solution:
    def rob(self, nums: List[int]) -> int:
        # n = len(nums)
        # f = [0] * (n+2)
        # for i, x in enumerate(nums):
        #     f[i+2] = max(f[i+1], f[i] + x)
        # return f[-1]
        f0 = 0
        f1 = 0
        for i, x in enumerate(nums):
            f0, f1 = f1, max(f1, f0+x)
        return f1        