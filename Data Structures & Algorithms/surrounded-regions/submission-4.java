class Solution {
    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        int row = board.length;
        int col = board[0].length;
        
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                queue.offer(new int[]{r, 0});
            }
        }
        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                queue.offer(new int[]{0, c});
            }
        }
        for (int r = 0 ; r < row; r++){
            if (board[r][col - 1] == 'O') {
                queue.offer(new int[]{r, col - 1});
            }
        }
        for (int c = 0; c < col; c++) {
            if (board[row - 1][c] == 'O') {
                queue.offer(new int[]{row - 1, c});
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            board[r][c] = 'S';

            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && board[nr][nc] == 'O') {
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
}
