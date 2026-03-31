class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0 ,right = heights.length - 1;

        while (left < right) {
            int weight = right - left;
            int validHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, weight * validHeight);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
          }
        return maxArea;
    }
}
