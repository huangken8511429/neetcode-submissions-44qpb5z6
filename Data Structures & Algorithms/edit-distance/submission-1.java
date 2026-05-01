class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, n - 1, word1, word2, memo);
    }

    private int dfs(int i, int j, String word1, String word2, int[][] memo) {
        int m = word1.length();
        int n = word2.length();

        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);

        if (c1 == c2) {
            return memo[i][j] = dfs(i-1, j-1, word1, word2, memo);
        } 
        return memo[i][j] = Math.min(Math.min(dfs(i, j - 1, word1,word2, memo) + 1, dfs(i - 1, j, word1, word2, memo) + 1), dfs(i - 1, j - 1, word1, word2, memo) + 1);
    }
}
