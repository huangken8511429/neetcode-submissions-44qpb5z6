class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        dp[n+1][0] = 0;
        dp[n+1][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
               int nothing = dp[i + 1][j];
               if (j == 1) {
                int buy = dp[i + 1][0] - prices[i];
                dp[i][j] = Math.max(nothing, buy);
               } else {
                int sell = dp[i + 2][1] + prices[i];
                dp[i][j] = Math.max(nothing, sell);
               }
            }
        }
        
      return dp[0][1];
    }
}