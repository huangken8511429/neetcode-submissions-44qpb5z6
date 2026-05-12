class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
    int max = Integer.MIN_VALUE;
    for (int start = 0; start < n; start++) {
        int sum = 0;
        for (int i = start; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
    }
    return max;
    }
}
