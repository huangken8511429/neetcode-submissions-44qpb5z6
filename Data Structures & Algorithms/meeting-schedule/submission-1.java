/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        if (intervals.isEmpty()){
            return true;
        }
        int prevEnd = intervals.get(0).end;
        
        for (int i = 1 ; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= prevEnd) {
                prevEnd = interval.end;
            } else {
                return false;
            }
        }
        return true;
    }
}
