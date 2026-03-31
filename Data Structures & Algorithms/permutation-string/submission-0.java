class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnts = new int[26];
        for (char c : s1.toCharArray()) {
            cnts[c - 'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            cnts[c - 'a']--;
            while (l <= r && cnts[c - 'a'] < 0) {
                cnts[s2.charAt(l) - 'a']++;
                l++;
            }

            if (r - l + 1 == s1.length()) {
                return true;   
            }
        }

        return false;
    }
}
