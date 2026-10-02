class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap  = {}

        for i, num in enumerate(nums):
            key = target - num
            if key in prevMap:
                return [prevMap[key], i]
            prevMap[num] = i    
        return []        

                