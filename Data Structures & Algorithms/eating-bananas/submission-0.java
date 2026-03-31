class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        int result = maxSpeed;

        int left = 1 , right = maxSpeed;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }
            if (totalTime <= h) {
                right = mid -1;
                result = mid;
            } else {
                left = mid + 1;
            } 
        }
        return result;
    }
}
