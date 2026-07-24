class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0] + self.rob1(nums[2:-1]), self.rob1(nums[1::]))

    def rob1(self, nums: List[int]) -> int:
        n = len(nums)
        f0 = 0
        f1 = 0
        for i in range(n):
            tmp = max(f1, f0 + nums[i])
            f0 = f1
            f1 = tmp
        return f1            