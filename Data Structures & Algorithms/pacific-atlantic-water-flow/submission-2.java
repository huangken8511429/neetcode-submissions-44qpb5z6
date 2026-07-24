class Solution {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacfic = new boolean[row][col];

        for (int c = 0; c < col; c++) {
            dfs(0, c, pacfic, heights);
        }

        for (int r = 0 ; r < row; r++) {
            dfs(r, 0, pacfic, heights);
        }

        boolean[][] atlan = new boolean[row][col];
        for (int c = 0; c < col; c++) {
            dfs(row - 1, c, atlan, heights);
        }

        for (int r = 0; r < row -1; r++) {
            dfs(r, col - 1, atlan, heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int r = 0 ; r < row; r++){
            for (int c = 0; c < col;  c++) {
                if (pacfic[r][c] && atlan[r][c]) {
                    ans.add(List.of(r,c));
                }
            }
        }
        return ans;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        if (visited[r][c]) {
            return;
        }
        visited[r][c] = true;

        for (int[] d : DIRS) {
            int x = r + d[0], y = c + d[1];
            if (0 <= x && x < heights.length && 0 <= y && y < heights[x].length && heights[x][y] >= heights[r][c]) {
                dfs(x, y, visited, heights);
            }
        }
    }
}
