class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, true, prices, memo);
    }
    
    private int dfs(int i, boolean buying, int[] prices, int[][] memo) {
        int n = prices.length;
        if (i >= n) {
            return 0;
        }
        int state = buying ? 1 : 0;
        if (memo[i][state] != -1) {
            return memo[i][state];
        }
        int cool = dfs(i+1, buying, prices, memo); // 什麼都不做的成本

        if (buying) {
            int buy = dfs(i+1, false, prices, memo) - prices[i];
            return memo[i][state] = Math.max(buy, cool);
        } else {
            int sell = dfs(i+2, true, prices, memo) + prices[i];
            return memo[i][state] = Math.max(sell, cool);
        }
    }
}
