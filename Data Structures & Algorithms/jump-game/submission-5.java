class Solution {
    public boolean canJump(int[] nums) {
        return dfs(0, nums);
    }
    private boolean dfs(int i, int[] nums) {
        if (i >= nums.length - 1) {
            return true;
        }
        int current = Math.min(nums.length, i + nums[i]);
        for (int j = i + 1; j <= current; j++) {
            if (dfs(j, nums)) {
                return true;
            }
        }
        return false;
    }
}
