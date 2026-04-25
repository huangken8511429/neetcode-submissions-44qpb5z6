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
        int[] dp = new int[capacity+1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = capacity; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[capacity];
    }
}
