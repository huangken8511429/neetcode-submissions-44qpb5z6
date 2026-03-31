class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int ansLeft = -1 , ansRight = s.length() - 1;

        int[] count = new int[128];
        int different  = 0;
        int formed = 0;
        for (Character c : t.toCharArray()) {
            if (count[c] == 0) {
                different++;
            }
            count[c]++;
        }
        int[] countS = new int[128];
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for (int right = 0 ; right < s.length(); right++) {
            char r = s.charAt(right);
            countS[r]++;
            if (countS[r] == count[r]) {
                formed ++;
            }
            while (formed == different) { 
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    ansLeft = left;
                    ansRight = right;
                }
                char l = s.charAt(left);
                countS[l]--;
                left++;
                if (countS[l] < count[l]) {
                   formed--;
                  }
                 }
                }
              return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
            }    
    }    
