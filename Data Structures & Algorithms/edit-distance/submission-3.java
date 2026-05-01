class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n+1];
        for (int j = 0; j < n; j++) {
            dp[j+1] = j+1;
        }
        for (int i = 0; i < m; i++) {
            int pre = dp[0];
            dp[0]++;
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                int tmp = dp[j+1];               
                if (c1 == c2) {
                    dp[j+1] = pre;
                } else {
                    dp[j+1] = Math.min(pre, Math.min(dp[j], dp[j+1])) + 1;
                }
                pre = tmp;
            }
        }
        return dp[n];
    }
}
