class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prevEnd = intervals[0][1];

        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}
