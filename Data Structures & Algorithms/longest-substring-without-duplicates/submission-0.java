class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int[] cnt = new int[128];
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = charArray[right];
            cnt[c]++;
            while (cnt[c] > 1) {
                cnt[charArray[left]]--;
                left++;
            }
         ans = Math.max(ans, right - left + 1);       
        }
        return ans;
    }
}
