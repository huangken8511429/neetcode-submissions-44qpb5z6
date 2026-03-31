class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n == 0) {
            memo[n] = 1;
        }
        if (n == 1) {
            memo[n] = 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        
        int chooseOne = dfs(n - 1, memo);
        int chooseTwo = dfs(n - 2, memo);

        return memo[n] = chooseOne + chooseTwo;
    }
}
