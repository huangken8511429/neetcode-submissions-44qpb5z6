class Solution {
    public boolean canJump(int[] nums) {
       Boolean[] memo = new Boolean[nums.length];
       return dfs(0, nums, memo);
    }
    private boolean dfs(int i , int[] nums, Boolean[] memo) {
        if (i == nums.length - 1) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        int end = Math.min(nums.length - 1, i + nums[i]);
        for (int j = i+1; j <= end; j++) {
            if (dfs(j, nums, memo)) {
                return memo[i] = true;
            }
        }
        return memo[i] = false;
    }
}
