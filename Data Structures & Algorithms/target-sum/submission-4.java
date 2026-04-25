class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return dfs(n-1, 0, nums, target);
    }
    private int dfs(int i, int j, int[] nums, int target) {
        if (i < 0) {
            return j == target ? 1 : 0;
        }

        return dfs(i-1, j + nums[i], nums, target) + dfs(i - 1, j - nums[i], nums, target);
    }

}
