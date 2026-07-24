class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0 || sum % 2 != 0){
            return false;
        }

        sum = sum / 2; // 背包容量
        Boolean[][] memo = new Boolean[n][sum + 1];

        return dfs(n - 1, memo, sum, nums);
    }

    private boolean dfs(int i , Boolean[][] memo, int sum, int[] nums) {
        if (i < 0) {
            return sum == 0;
        }
        if (memo[i][sum] != null) {
            return memo[i][sum];
        }
        boolean choose = false;
        boolean notChoose = dfs(i - 1, memo, sum, nums);
        if (nums[i] <= sum) {
        choose = dfs(i - 1, memo, sum - nums[i], nums);
        }
        
        memo[i][sum] = notChoose || choose;
        return memo[i][sum];
    }
}
