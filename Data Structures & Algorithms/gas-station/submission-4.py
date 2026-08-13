class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        currentTank = 0
        totalTank = 0
        ans = 0

        n = len(gas)
        for i in range(n):
            netprofit = gas[i] - cost[i]
            currentTank += netprofit
            totalTank += netprofit
            if currentTank <= -1:
                ans = i + 1
                currentTank = 0
        return ans if totalTank >= 0 else -1         
