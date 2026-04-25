class Solution {
    Map<String, Integer> map = new HashMap<>();
    private int sum = 0;
    
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            sum += num;
        }
        sum -= Math.abs(target);
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        int n = nums.length;
        int capacity = sum / 2;
        int[][] dp = new int[n+1][capacity+1];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i+1][j] = dp[i][j];
                if (j >= nums[i]) {
                    dp[i+1][j] += dp[i][j - nums[i]];
                }
            }
        }
        
        return dp[n][capacity];
    }
}
