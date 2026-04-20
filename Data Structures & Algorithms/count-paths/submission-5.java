class Solution {

    // grid[row][col] = grid[row-1][col] + grid[row][col-1];
    // 如果只有一個一維陣列，從左邊往右邊掃的話，grid[col] => 這個代表上一個 => grid[row-1][col]
    // 我們可以發現一個規律 grid[col] = grid[col] + grid[col - 1] => grid[col] += grid[col - 1]
     public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        Arrays.fill(f, 1);

       for (int row = 1; row < m; row++) {
        for (int col = 1; col < n; col++) {
           f[col] += f[col - 1];
        }
       } 
      
      return f[n - 1];
    }
}
