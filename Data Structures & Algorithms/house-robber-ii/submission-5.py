class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0] + self.rob1(nums[2:-1]), self.rob1(nums[1:]))

    def rob1(self, nums: List[int]) -> int:
        f0 = 0
        f1 = 0
        for i, x in enumerate(nums):
            newF = max(f1, f0 + x)
            f0 = f1
            f1 = newF
        return f1    

