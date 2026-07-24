class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int area = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                area = Math.max(area, dfs(r, c, grid));
                }
            }
        }
        return area;
    }

    private int dfs(int r, int c, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int ans = 1;
        ans += dfs(r - 1, c, grid);
        ans += dfs(r + 1, c, grid);

        ans += dfs(r, c + 1, grid);       
        ans += dfs(r, c - 1, grid);
        return ans;
    }
}
