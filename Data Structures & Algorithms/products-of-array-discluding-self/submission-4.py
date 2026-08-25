class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = 1
        n = len(nums)
        prefix = [1] * n

        for i in range(1, n):
            prefix[i] = res * nums[i-1]
            res = res * nums[i-1]
        
        res = 1
        postfix = [1] * n
        
        for i in range(n-2, -1, -1):
            postfix[i] = res * nums[i+1]
            res = res * nums[i+1]  
        
        for i in range(n):
            prefix[i] = prefix[i] * postfix[i]
        
        return prefix