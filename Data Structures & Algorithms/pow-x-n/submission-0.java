class Solution {
    public double myPow(double x, int n) {
        // 3
        double result = 1.0;
        if (n > 0) {
         for (int i = 0; i < n; i++) {
            result *= x;
         }
        } else {
            n *= -1;
            for (int i = 0; i < n; i++) {
                result /= x;
            }
        }
        
        return result;
    }
}
