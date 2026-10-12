
from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []

        for i in range(n - 2):
            # 去除重複的起始數字
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # 剪枝：最小的三數總和已經大於 0
            if nums[i] + nums[i + 1] + nums[i + 2] > 0:
                break

            # 剪枝：最大的三數總和仍小於 0
            if nums[i] + nums[-2] + nums[-1] < 0:
                continue

            left = i + 1
            right = n - 1

            while left < right:
                total = nums[i] + nums[left] + nums[right]

                if total == 0:
                    ans.append([nums[i], nums[left], nums[right]])

                    originLeft = nums[left]
                    originRight = nums[right]

                    left += 1
                    right -= 1

                    # 跳過重複的左側數字
                    while left < right and nums[left] == originLeft:
                        left += 1

                    # 跳過重複的右側數字
                    while left < right and nums[right] == originRight:
                        right -= 1

                elif total < 0:
                    left += 1

                else:
                    right -= 1

        return ans
