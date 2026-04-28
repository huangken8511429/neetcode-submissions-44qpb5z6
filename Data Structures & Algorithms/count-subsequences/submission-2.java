class Solution {
    public int numDistinct(String S, String T) {
        int s = S.length();
        int t = T.length();
        if (t > s) {
            return 0;
        }
        int[][] dp = new int[s+1][t+1];
        for (int i = 0; i < s; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0 ; i < s; i++) {
            for (int j = 1 ; j <= t; j++) {
                dp[i+1][j] = dp[i][j];
                if (S.charAt(i) == T.charAt(j - 1)) {
                    dp[i+1][j] += dp[i][j-1];
                }
            }
        }
        return dp[s][t];
    }
}
