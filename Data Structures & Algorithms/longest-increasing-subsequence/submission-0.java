class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, -1, nums, memo);
    }

    private int dfs(int now, int prev, int[] nums, int[][] memo) {
        if (now == nums.length) {
            return 0;
        }
        if (memo[now][prev + 1] != -1) {
            return memo[now][prev + 1];
        }
        // 不選
        int ans = dfs(now + 1, prev, nums, memo);
        // 選 (建立在下一個比當前的大)
        if (prev == -1 || nums[now] > nums[prev]) {
            ans = Math.max(ans, 1 + dfs( now + 1, now, nums, memo));
        }    
        return memo[now][prev+1] = ans;
    }
}
