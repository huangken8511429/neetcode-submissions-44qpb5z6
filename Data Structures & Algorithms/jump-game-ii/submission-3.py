class Solution:
    def jump(self, nums: List[int]) -> int:
        currentEnd = farthest = 0
        jump = 0
        n = len(nums)

        for i in range(n-1):
            farthest = max(farthest, i + nums[i])
            if i == currentEnd:
                jump += 1
                currentEnd = farthest
            if currentEnd >= n-1:
                break
        return jump            