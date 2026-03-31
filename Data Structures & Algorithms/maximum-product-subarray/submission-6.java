class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE; // 注意答案可能是负数
        int fMax = 1;
        int fMin = 1;

        // f[i] = Math.max(f[i-1] * now, now)
        for (int now : nums) {
            int prevMax = fMax;
            fMax = Math.max(Math.max(fMax * now, fMin * now), now);
            // 因為fMax已經更新過了，所以要用之前的fMax
            fMin = Math.min(Math.min(prevMax * now, fMin * now), now);
            ans = Math.max(ans, fMax);
        }
        return ans;
    }
}
