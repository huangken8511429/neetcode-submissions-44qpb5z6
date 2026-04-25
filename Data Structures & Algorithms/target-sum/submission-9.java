class Solution {
    Map<String, Integer> map = new HashMap<>();
    private int sum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int n = nums.length;
        
        int[][] memo = new int[n][2 * sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(n-1, 0, nums, target, memo);
    }

    private int dfs(int i, int j, int[] nums, int target, int[][] memo) {
        if (i < 0) {
            return j == target ? 1 : 0;
        }
        if (memo[i][j + sum] != -1) {
            return memo[i][j + sum];
        }
        
        int result = dfs(i-1, j + nums[i], nums, target, memo) + dfs(i - 1, j - nums[i], nums, target, memo);
        return memo[i][j + sum] = result;
    }
}
