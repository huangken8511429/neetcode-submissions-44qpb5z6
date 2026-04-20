class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int[] row : grid) {
            Arrays.fill(row, -1);
        }
        
        return dfs(0, 0, m, n, grid);
    }

    private int dfs(int row, int col, int m, int n, int[][] grid) {
        if (row >= m || col >= n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (grid[row][col] != -1) {
            return grid[row][col];
        }        
        int ans = 0;
        ans += dfs(row + 1, col, m, n, grid); 
        ans += dfs(row, col + 1, m, n, grid);
        return grid[row][col] = ans;
    }
}
