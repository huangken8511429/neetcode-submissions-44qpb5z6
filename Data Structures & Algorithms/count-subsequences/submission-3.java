class Solution {
    public int numDistinct(String S, String T) {
        int s = S.length();
        int t = T.length();
        if (t > s) {
            return 0;
        }
        int[] dp = new int[t+1];
        dp[0] = 1;
        
        for (int i = 0 ; i < s; i++) {
            for (int j = t ; j >= 1; j--) {
                if (S.charAt(i) == T.charAt(j - 1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[t];
    }
}
