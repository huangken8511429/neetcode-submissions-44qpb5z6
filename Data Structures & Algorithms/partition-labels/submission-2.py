class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}

        for i, c in enumerate(s):
            lastIndex[c] = i

            #  x : 3
            #  y : 4

        ans = []
        maxReach = 0

        left = 0
        for right, c in enumerate(s):
            maxReach = max(maxReach, lastIndex[c])

            if right == maxReach:
                ans.append(right - left + 1)
                left = right + 1
        return ans        


