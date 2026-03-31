class Solution {
    public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return dfs(n, cost, memo);
 }
// dfs(0)=0, dfs(1)=0。爬到 0 或 1 无需花费，因为我们一开始在 0 或 1。
 private int dfs(int n, int[] cost, int[] memo) {
    if (n <= 1) {
        return 0;
    }

    if (memo[n] != -1) {
        return memo[n];
    }

    int one = cost[n - 1]  + dfs(n - 1, cost, memo);
    int two = cost[n - 2] + dfs(n-2, cost, memo);
    return memo[n] = Math.min(one, two);
 }
}
