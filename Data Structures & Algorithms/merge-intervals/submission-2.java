class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int prevMin = intervals[0][0];
        int prevMax = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > prevMax) {
                // 不能合併：把累積的區間加進 result，並重置
                result.add(new int[]{prevMin, prevMax});
                prevMin = intervals[i][0];
                prevMax = intervals[i][1];
            } else {
                // 可以合併：只需要延伸 prevMax
                prevMax = Math.max(prevMax, intervals[i][1]);
            }
        }
        
        // 別忘了最後一組區間
        result.add(new int[]{prevMin, prevMax});
        
        return result.toArray(new int[result.size()][2]);
    }
}
