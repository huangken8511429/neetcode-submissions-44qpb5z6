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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            heap.offer(interval.end);
        }
        if (intervals.isEmpty()) {
            return 0;
        }
        int count = 0;
        int prevStart = intervals.get(0).start;
        int prevEnd = intervals.get(0).end;

        for (int i = 1 ; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= heap.peek()) {
                heap.poll();
            } else {
                count++;
            }
        }
        return count + 1;
    }
}
