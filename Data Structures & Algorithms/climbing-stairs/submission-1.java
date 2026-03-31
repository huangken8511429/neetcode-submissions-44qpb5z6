class Solution {
    public int climbStairs(int n) {
        int f0 = 0;
        int f1 = 1;
        for (int i = 0; i < n; i++) {
            int newF = f0 + f1;
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
