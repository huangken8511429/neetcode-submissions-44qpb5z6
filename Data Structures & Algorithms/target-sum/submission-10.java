class Solution {
    Map<String, Integer> map = new HashMap<>();
    private int sum = 0;
    
    // p = 正數 q = 負數絕對值
    // p + q = S
    // p - q = target
    // p  =  S + target / 2 ;
    // q  =  S - target / 2 
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
        int[][] memo = new int[n+1][capacity+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return dfs(n-1, capacity, nums, memo);
    }

    private int dfs(int i, int c, int[] nums, int[][] memo) {
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) {
            return memo[i][c];
        }
        int ans = dfs(i - 1, c, nums, memo);
        if (c >= nums[i]) {
            ans += dfs(i - 1, c - nums[i], nums, memo);
        }
        return memo[i][c] = ans;
    }
}
