class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        n = len(nums)
        f_max = [0] * (n+1)
        f_min = [0] * (n+1)

        f_min[0] = f_max[0] = nums[0]
        ans = nums[0]
        
        # f[i] = max(f[i-1], 0) + x
        # f[i] = max(f[i-1] * x, x)
        for i in range(1, n):
            x = nums[i]
            f_max[i] = max(f_max[i-1] * x, f_min[i-1] * x, x)
            f_min[i] = min(f_max[i-1] * x, f_min[i-1] * x, x)
            ans = max(ans, f_max[i])
        return ans    