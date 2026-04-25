class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length() + 1][s2.length()+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, 0, s1, s2, s3, memo);
    }

    private boolean dfs(int i, int j, int k, String s1, String s2, String s3, int[][] memo) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        if (memo[i][j] != -1) {
            return memo[i][j] == 1 ? true : false;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
             if (dfs(i+1, j, k+1, s1, s2, s3, memo)) {
                memo[i][j] = 1;
                return true;
             }
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(i, j+1, k+1, s1, s2, s3, memo)) {
                memo[i][j] = 1;
                return true;
            }
        }
        memo[i][j] = 0;
        return false;
    }
}
