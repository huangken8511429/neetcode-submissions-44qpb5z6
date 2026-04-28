class Solution {
    public int numDistinct(String s, String t) {
        int i = s.length();
        int j = t.length();
        if (j > i) {
            return 0;
        }
        int[][] memo = new int[i+1][j+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(i - 1, j - 1, s, t, memo);
    }
    private int dfs(int i, int j, String s, String t, int[][] memo) {
        if (i < 0 && j >= 0) {
            return 0;
        }
        if (j < 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        int res = dfs(i - 1, j, s, t, memo);
        if (c1 == c2) {
            int choose = dfs(i - 1, j - 1, s, t, memo);
            res = choose + res;
        } 
        return memo[i][j] = res;
    }
}
