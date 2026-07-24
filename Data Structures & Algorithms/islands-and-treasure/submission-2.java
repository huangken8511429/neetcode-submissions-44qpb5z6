class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r,c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == Integer.MAX_VALUE) {
                    queue.offer(new int[] { nr, nc} );
                    grid[nr][nc] = grid[r][c] + 1;
                }
            }
        }        
    }
}