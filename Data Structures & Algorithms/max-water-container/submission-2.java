class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int area = 0;

        while (left < right) {
          if (heights[left] < heights[right]) {
            area = Math.max(area, (right - left) * heights[left]);
            left++;
          } else {
            area = Math.max(area, (right - left) * heights[right]);
            right--;
          }
        }
        return area;
    }
}
