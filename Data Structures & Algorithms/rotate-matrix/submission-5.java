class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        int n = matrix.length;
        for (int i = 0 ; i < n; i++) {
            for (int j = i; j < matrix[i].length; j++) { //避免重複交換，所以j從i開始
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i]; // 沿著左上到右下的對角線，將對立的matrix做交換
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
    }
}
