from functools import cache
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums) 
        target += sum(nums) 
        if target % 2 != 0:
            return 0
        target //= 2
        f = [0] * (target+1)
        f[0] = 1
        # f[i][c] = f[i-1][c] + f[i-1][c - nums[i]]
        # f[c] = f[c] + f[c-nums[i]]
        # 因為會依賴前一個狀態，如果是正序遍歷，會蓋掉前一個狀態的值，所以要後續遍歷(0/1背包)  
        for x in nums:
            for c in range(target, x-1, -1):
                f[c] = f[c] + f[c - x]
        return f[target]                    

