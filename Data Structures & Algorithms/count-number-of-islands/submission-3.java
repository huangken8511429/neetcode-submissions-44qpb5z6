class Solution {
    private final int[][] directions = {{1,0}, {-1,0}, {0,-1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] dir : directions) {
            dfs(i + dir[0], j + dir[1], grid);
        }
    }
}
