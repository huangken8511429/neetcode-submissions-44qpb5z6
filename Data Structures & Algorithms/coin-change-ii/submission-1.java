class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n+1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);        
        }
        return dfs(0, amount, coins, memo);
    }

    private int dfs(int i, int amount, int[] coins, int[][] memo) {
       int n = coins.length;
        if (i >= n) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }
        int ans = 0;
        if (coins[i] > amount) {
            ans += dfs(i+1, amount, coins, memo);
        } else {
            ans += dfs(i+1, amount, coins, memo);
            ans += dfs(i, amount - coins[i], coins, memo);
        }
        return memo[i][amount] = ans;
    }
}
