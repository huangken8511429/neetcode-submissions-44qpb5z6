class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j < n; j++){
            dp[j + 1] = j + 1;
        }
        for (int i = 0 ; i < m; i++) {
            int pre = dp[0];
            dp[0]++;
            for (int j = 0; j < n; j++) {
                int c1 = word1.charAt(i);
                int c2 = word2.charAt(j);
                int tmp = dp[j+1];          // 先把 dp[i-1][j+1] 存起來，下一輪要當 pre 用
                if (c1 == c2) {
                   dp[j+1] = pre;          // pre 是 dp[i-1][j]，所以 dp[i][j+1] = dp[i-1][j]
                } else {
                   dp[j+1] = Math.min(pre, Math.min(dp[j], dp[j+1])) + 1;
                  // pre=左上, dp[j]=左, dp[j+1]=上（還沒覆蓋前）
                }
                    pre = tmp;                  // 下一輪的左上角 = 這一輪的正上方
            }
        }
        return dp[n];
    }
}
