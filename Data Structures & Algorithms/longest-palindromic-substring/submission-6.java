class Solution {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int ansLeft = 0;
        int ansRight = 0;

        // % 2 == 1
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && c[l] == c[r]) {
                l--;
                r++;
            }
            // 結束後 [l+1, r-1] 才是正確回文
            if (r - l - 1 > ansRight - ansLeft) {
                ansLeft = l + 1;
                ansRight = r; 
            }
        }

        // % 2 == 0
        for (int i = 0 ; i < n - 1; i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < n && c[l] == c[r]) {
                l--;
                r++;
            }
            // 結束後 [l+1, r-1] 才是正確回文
            if (r - l - 1 > ansRight - ansLeft) {
                ansLeft = l + 1;
                ansRight = r;
            }
        }

        return s.substring(ansLeft, ansRight);
    }
}
