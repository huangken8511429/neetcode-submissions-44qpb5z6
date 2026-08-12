class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) <= 1:
            return intervals

        # Step 1: 按照開始時間排序
        intervals.sort(key=lambda x: x[0])

        result = []

        # 先放入第一個區間作為基準
        currentInterval = intervals[0]
        result.append(currentInterval)

        for interval in intervals:
            currentEnd = currentInterval[1]
            nextStart = interval[0]
            nextEnd = interval[1]

            if nextStart <= currentEnd:
                # 有重疊，更新目前區間的結束邊界
                currentInterval[1] = max(currentEnd, nextEnd)
            else:
                # 沒有重疊，開啟新的區間
                currentInterval = interval
                result.append(currentInterval)

        return result