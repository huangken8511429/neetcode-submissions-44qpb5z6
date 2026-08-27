class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        numSet = set(nums)

        for num in numSet:
            below = num - 1
            if below not in numSet:
                current = 1
                while (num+1) in numSet:
                    current += 1
                    num += 1
                ans = max(ans, current)
        return ans        