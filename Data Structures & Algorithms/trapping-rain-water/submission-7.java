class Solution {
    public int trap(int[] height) {
     int left = 0;
     int right = height.length - 1;
     int leftMax = 0;
     int rightMax = 0;
     int trap = 0;
     while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (leftMax < rightMax) {
        trap += leftMax - height[left];
        left++;
      } else {
        trap += rightMax - height[right];
        right--;
      }
     }
     return trap;
    }
}
