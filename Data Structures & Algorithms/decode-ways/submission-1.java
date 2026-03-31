class Solution {
    public int numDecodings(String s) {
        int f0 = 1; // 空字串
        int f1 = s.charAt(0) != '0' ? 1 : 0;
        // f[i] 代表 到第i個字的時候，會有多少個組合

        for (int i = 2; i <= s.length(); i++) {
           int cur = 0;
           if (s.charAt(i - 1) != '0') cur += f1;
           int two = Integer.parseInt(s.substring(i-2, i));
           if (two >= 10 && two <= 26) {
            cur += f0;
           } 
           f0 = f1;
           f1 = cur;
        }
        return f1;
    }
}
