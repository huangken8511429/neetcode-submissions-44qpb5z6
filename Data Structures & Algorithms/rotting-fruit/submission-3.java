class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r , c});
                }
            }
        }
        int ans = 0;
        while (fresh > 0 && !queue.isEmpty()) {
         for (int i = queue.size(); i > 0; i--) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
             
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    queue.offer(new int[]{nr, nc});
                    fresh--;
                }   
              }
            }
            ans += 1;
        }
        return fresh == 0 ? ans : -1;
    }
}
