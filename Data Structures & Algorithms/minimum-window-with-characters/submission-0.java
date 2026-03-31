class Solution {
    public String minWindow(String s, String t) {
       int[] countT = new int[128];
       for (Character c : t.toCharArray()) {
        countT[c]++;
       }
       int[] countS = new int[128];
      
       
       int ansLeft = -1, ansRight = s.length() - 1;
       int left = 0;

       for (int right = 0 ; right < s.length(); right++) {
        char r = s.charAt(right);
        countS[r]++;

        while (isCovered(countS, countT)) {
            if (right - left < ansRight - ansLeft) {
                ansRight = right;
                ansLeft = left;
            }
            countS[s.charAt(left)]--;
            left++;
        }  
       }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight+1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
