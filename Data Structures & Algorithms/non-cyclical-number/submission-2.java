class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        while (!visit.contains(n)) {
            visit.add(n);
            n = square(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    private int square(int n) {
        int result = 0;
        while (n > 0) {
            int mod = n % 10;
            result += mod * mod;
            n /= 10;
        }
        return result;
    }
}
