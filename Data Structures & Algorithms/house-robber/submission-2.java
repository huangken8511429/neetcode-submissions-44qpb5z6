class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = nums[0];
        return dfs(n - 1, nums, memo);
    }
    
    // memo=[2, 1]
    private int dfs(int n, int[] nums, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        // dfs(2) + nums[2] = dfs(2) + 1
        // dfs(3)
        // dfs(4) = Math.max(dfs(2), dfs(3));
        int chooseTwo = dfs(n - 2, nums, memo) + nums[n];
        int chooseOne = dfs(n - 1, nums, memo);
        
        return memo[n] = Math.max(chooseTwo, chooseOne);
    }
}
