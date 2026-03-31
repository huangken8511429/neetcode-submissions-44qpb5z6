class Solution {
    public int rob(int[] nums) {
        int  n = nums.length;
        return Math.max(nums[0] + rob1(2, n -1 , nums), rob1(1, n, nums));
    }

    private int rob1(int start, int end, int[] nums) {
        int n = nums.length;
        int f0 = 0;
        int f1 = 0;
        for (int i = start; i < end; i++) {
            int newF = Math.max(f0 + nums[i], f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }
}
