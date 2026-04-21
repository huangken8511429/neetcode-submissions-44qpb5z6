class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, m, n, memo);
    }

    private int dfs(int row, int col, int m, int n, int[][] memo) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int ans = 0;
        ans += dfs(row + 1, col, m, n, memo);
        ans += dfs(row, col + 1, m, n, memo);
        return memo[row][col] = ans;
    }
}
