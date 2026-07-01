class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        left = 0
        right = n - 1
        area = 0

        while left < right:
            height = min(heights[left], heights[right])
            weight = right - left
            area = max(area, height * weight)
            if heights[left] <= heights[right]:
                left += 1
            else:
                right -= 1

        return area            


        