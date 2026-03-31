class Solution {
    // top = cost.length;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dfs(n, cost, memo);
    }


    private int dfs(int n, int[] cost, int[] memo) {
        if (n <= 1) {
            memo[n] = 0;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int chooseOne = dfs(n - 1, cost, memo) + cost[n - 1];
        int chooseTwo = dfs(n - 2, cost, memo) + cost[n - 2];

        return memo[n] = Math.min(chooseOne, chooseTwo);
    }
}
