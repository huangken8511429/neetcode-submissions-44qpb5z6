class Solution {
    public boolean hasDuplicate(int[] nums) {
        int left = 0,  right = left + 1;
        int n = nums.length;
        while (right <= nums.length - 1) {
            if (nums[left] == nums[right]) {
                return true;
            } else {
                right++;
            }
            if (right == n) {
                left++;
                right = left + 1;
            }
        }
        return false;
    }
}