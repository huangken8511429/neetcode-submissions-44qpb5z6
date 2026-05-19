public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (newInterval == null || newInterval.length == 0) {
            return new int[0][2];
        }
        for (int[] interval : intervals) {
            if (newInterval == null || newInterval[0] > interval[1]) {
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            } else {
                int min = Math.min(interval[0], newInterval[0]);
                int max = Math.max(interval[1], newInterval[1]);
                newInterval = new int[]{min, max};
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}