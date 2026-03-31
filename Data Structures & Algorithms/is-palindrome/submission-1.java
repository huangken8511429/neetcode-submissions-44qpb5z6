class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlpha(lowerCase.charAt(left))) {
                left++;
            }
            while (left < right && !isAlpha(lowerCase.charAt(right))) {
                right--;
            };
            char cleft = lowerCase.charAt(left);
            char cright = lowerCase.charAt(right);
            if (cleft != cright) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlpha(char c) {
        return c >= 'a' && c <= 'z' || 
               c >= 'A' && c <= 'Z' ||
               c >= '0' && c <= '9';
    }
}
