class Solution {
    public int countSubstrings(String S) {
        int count = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        
        // 奇數 
        for (int i = 0 ; i < n ; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n) {
                if (s[l] == s[r]) {
                    count++;
                } else {
                    break;
                }
                l--;
                r++;
            }
        }

        // 偶數 
        for (int i = 0 ; i < n ; i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < n) {
               if (s[l] == s[r]) {
                    count++;
                } else {
                    break;
                }
                l--;
                r++;
            }
        }
        return count;
    }
}
