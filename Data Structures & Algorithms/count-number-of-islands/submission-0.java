class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0 ; c < col; c++) {
                if (grid[r][c] == '1') {
                   ans += 1;
                   dfs(r, c, grid);
                }
            }
        }
        return ans;
    }


    private void dfs(int r, int c, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
    }
}
