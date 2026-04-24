class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, true, prices, memo); // 從第 i 天開始，在 buying 狀態下，未來最多能賺多少 profit
    }
    
    private int dfs(int i, boolean buying, int[] prices, int[][] memo) {
        if (i >= prices.length) {
            return 0;
        }
        int state = buying ? 1 : 0;
        if (memo[i][state] != -1) {
            return memo[i][state];
        }
        int nothing = dfs(i+1, buying, prices, memo);

        if (buying) {
            int buy = dfs(i+1, false, prices, memo) - prices[i];
            return memo[i][state] = Math.max(nothing, buy);
        } else {
            int sell = dfs(i+2, true, prices, memo) + prices[i];
            return memo[i][state] = Math.max(nothing, sell);
        }
    }
}
