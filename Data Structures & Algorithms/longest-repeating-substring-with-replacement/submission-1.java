class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int ans = 0;

        int maxf = 0;
        int[] record = new int[128];
    
        for (int right = 0 ; right < s.length(); right++) {
            char r = s.charAt(right);
            record[r]++;
            maxf = Math.max(maxf, record[r]);

            while ((right - left + 1) - maxf > k) {
                record[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
