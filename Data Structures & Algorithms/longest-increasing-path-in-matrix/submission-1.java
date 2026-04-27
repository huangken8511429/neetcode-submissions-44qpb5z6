class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 0;
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int[][] memo = new int[row][col];
        for (int[] r : memo) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, Integer.MIN_VALUE, memo));
            }
        }
        return ans;
    }

    private int  dfs(int i, int j, int[][] matrix, int upper, int[][] memo) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= upper) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 1;
        for (int[] d: directions) {
            res = Math.max(res, 1 + dfs(i + d[0], j + d[1], matrix, matrix[i][j], memo));
        }
        return memo[i][j] = res;
    }
}
