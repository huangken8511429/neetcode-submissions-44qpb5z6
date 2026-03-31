class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length , cols = matrix[0].length;
        int left = 0 , right = rows * cols;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int col = mid / cols , row = mid % cols;
            if (matrix[col][row] > target) {
                right = mid;
            } else if (matrix[col][row] < target) {
                left = mid +1;
            } else {
                return true;
            }
        }
        return false;
    }
}
