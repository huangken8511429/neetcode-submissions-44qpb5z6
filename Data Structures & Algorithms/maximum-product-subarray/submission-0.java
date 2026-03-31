class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmin = new int[n];
        int[] fmax = new int[n];
        fmin[0] = fmax[0] = nums[0];

        for (int i = 1 ;  i < n; i++) {
            int now = nums[i];
            fmax[i] = Math.max(Math.max(fmax[i-1] * now, fmin[i-1] * now), now);
            fmin[i] = Math.min(Math.min(fmax[i-1] * now, fmin[i-1] * now), now);
        }
        return Arrays.stream(fmax).max().getAsInt();
    }
}
