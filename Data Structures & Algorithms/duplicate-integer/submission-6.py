class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        duplicate = set(nums)

        return len(duplicate) != len(nums)