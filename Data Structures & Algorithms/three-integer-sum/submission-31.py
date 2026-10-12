
from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        n = len(nums)
        for i in range(n-2):
            num = nums[i]
            if i > 0 and nums[i-1] == num:
                continue
            if i + 2 < n and num + nums[i+1] + nums[i+2] > 0:
                break
            if num + nums[-1] + nums[-2] < 0:
                continue

            left = i + 1
            right = n - 1

            while left < right:
                total = num + nums[left] + nums[right]
                if total == 0:
                    ans.append((num, nums[left], nums[right]))
                    originLeft = nums[left]
                    originRight = nums[right]

                    left += 1
                    right -= 1

                    while left < right and nums[left] == originLeft:
                        left += 1
                    while left < right and nums[right] == originRight:
                        right -= 1
                elif total < 0:
                    left += 1
                else:
                    right -= 1
        return ans                            