class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         int m = text1.length(), n = text2.length();
         int[] dp = new int[n + 1];

    for (int i = 1; i <= m; i++) {
        int prev = 0;  // 代表 dp[i-1][j-1],第一次是 dp[i-1][0] = 0
        for (int j = 1; j <= n; j++) {
            int temp = dp[j];  // 先存起來,這是 dp[i-1][j](馬上會被覆蓋)
            if (text1.charAt(i-1) == text2.charAt(j-1)) {
                dp[j] = prev + 1;                      // dp[i-1][j-1] + 1
            } else {
                dp[j] = Math.max(dp[j], dp[j-1]);      // max(上, 左)
                //                ↑上一列的舊值  ↑這一列的新值
            }
            prev = temp;  // 更新 prev 給下一次迭代當「對角」用
        }
    }
    return dp[n];
    }
    
}
