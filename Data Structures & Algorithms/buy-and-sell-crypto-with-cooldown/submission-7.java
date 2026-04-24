class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold = 0;      // dp[i+1][0]：下一天處於 holding 狀態的最佳值
        int cash = 0;      // dp[i+1][1]：下一天處於 buying 狀態的最佳值
        int cashPrev = 0;  // dp[i+2][1]：下下天處於 buying 狀態的最佳值（給 sell 用的，因為賣完要冷凍一天）

        for (int i = n - 1; i >= 0; i--) {
            int newHold = Math.max(hold, cashPrev + prices[i]);  // 不賣 or 賣掉
            int newCash = Math.max(cash, hold - prices[i]);      // 不買 or 買入

            cashPrev = cash;   // i+1 的 cash 變成下一輪的 i+2 的 cash
            cash = newCash;
            hold = newHold;
        }

        return cash;  // 對應 dp[0][1]：第 0 天從 buying 狀態開始
    }
}