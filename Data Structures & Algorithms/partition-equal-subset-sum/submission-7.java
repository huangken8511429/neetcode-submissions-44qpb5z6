class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0 || sum % 2 != 0){
            return false;
        }
        
         // f[n][c] = f[n-1][c - nums[i]] || f[n-1][c];
         // f[c] = f[c - nums[i]] || f[c];
        sum = sum / 2; // 背包容量

        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int num : nums) {
            for (int c = sum; c >= num ; c--) {
                f[c] = f[c - num] || f[c];
            }
        } 
        return f[sum];
    }
}
