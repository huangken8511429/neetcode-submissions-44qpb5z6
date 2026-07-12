class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        n = len(nums)

        for i in range(n-2):
            num = nums[i]
            left = i + 1
            right = n - 1
            if num + nums[i+1] + nums[i+2] > 0:
                break
            if num + nums[-1] + nums[-2] < 0:
                continue
            if i > 0 and nums[i] == nums[i-1]:
                continue
            while left < right:
                s = num + nums[left] + nums[right]
                if s > 0:
                    right -= 1
                elif s < 0:
                    left += 1
                else:
                    ans.append([num, nums[left], nums[right]])
                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                    right -= 1
                    while left < right and nums[right] == nums[right+1]:
                        right -= 1
        return ans                                      
            

        