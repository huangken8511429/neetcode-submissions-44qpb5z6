class Solution {

    // f[row][col] = f[row+1][col] + f[row][col+1]
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
