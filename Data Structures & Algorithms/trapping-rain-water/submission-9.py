class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = 0 
        right = n - 1
        prefix = 0
        suffix = 0

        ans = 0
        while left < right:
            prefix = max(height[left], prefix)
            suffix = max(height[right], suffix)
            if prefix <= suffix:
                ans += prefix - height[left]
                left += 1
            else:
                ans += suffix - height[right]
                right -= 1
        return ans            
