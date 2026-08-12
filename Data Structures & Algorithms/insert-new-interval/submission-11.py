class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        i = 0
        n = len(intervals)

        # 階段一：把所有在 newInterval 之前（不重疊）的區間直接加入
        while i < n and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1

        # 階段二：把所有與 newInterval 重疊的區間合併進 newInterval
        while i < n and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(newInterval[0], intervals[i][0])
            newInterval[1] = max(newInterval[1], intervals[i][1])
            i += 1
        result.append(newInterval)  # 合併後的新區間

        # 階段三：把所有在 newInterval 之後的區間直接加入
        while i < n:
            result.append(intervals[i])
            i += 1

        return result             

                
