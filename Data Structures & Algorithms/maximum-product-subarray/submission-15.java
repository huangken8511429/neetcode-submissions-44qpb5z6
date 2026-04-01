class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = max[0] = nums[0];

        for (int i = 1 ; i < n; i++) {
          int now = nums[i];
          max[i] = Math.max(Math.max(max[i - 1] * now, min[i - 1] * now), now);
          min[i] = Math.min(Math.min(max[i - 1] * now, min[i - 1] * now), now);
        }
        return Arrays.stream(max).max().getAsInt();
    }
}
