class Solution {
    // top = cost.length;
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);

        return Math.min(dfs(0, cost, memo), dfs(1, cost, memo));
    }


    private int dfs(int n, int[] cost, int[] memo) {
        if (n >= cost.length) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        int chooseOne = dfs(n + 1, cost, memo);
        int chooseTwo = dfs(n + 2, cost, memo);

        return memo[n] = cost[n] + Math.min(chooseOne, chooseTwo);
    }
}
