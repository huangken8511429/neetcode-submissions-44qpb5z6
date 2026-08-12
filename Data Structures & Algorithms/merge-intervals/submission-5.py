class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 1:
            return intervals
        intervals.sort(key=lambda pair:pair[0])

        res = [intervals[0]]

        for interval in intervals[1:]:
            current = res[-1]
            currentEnd = current[1]
            if interval[0] <= currentEnd:
                current[1] = max(current[1], interval[1])
            else:
                res.append(interval)
        return res                