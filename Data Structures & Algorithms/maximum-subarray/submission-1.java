class Solution {
    public int maxSubArray(int[] nums) {
       int max = nums[0];
       int cur = nums[0];
     for (int i = 1; i < nums.length; i++) {
        cur = Math.max(nums[i], cur + nums[i]); // 接著前面 or 從這裡重起
        max = Math.max(max, cur);
     }
    return max;
    }
}
