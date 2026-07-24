class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] memo = new int[n+1];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, nums, memo));
        }

        return ans;
    }

    private int dfs(int n, int[] nums,int[] memo) {
        int ans = 0;
        if (memo[n] != 0) {
            return memo[n];
        } 
        for (int i = 0 ; i < n; i++) {
            if (nums[i] < nums[n]) {
                // 這邊因為是正序開始 所以沒有 i -1 
               ans = Math.max(ans, dfs(i, nums, memo));
            }
        }
        return memo[n] = ans + 1;
    }
}

