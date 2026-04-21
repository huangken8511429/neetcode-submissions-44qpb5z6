class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int r = text1.length();
        int c = text2.length();
        int[][] dp = new int[r+1][c+1];

        for (int i = r - 1 ; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    
}
