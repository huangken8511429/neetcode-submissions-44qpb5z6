class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # f[n] = min (f[n-1] + cost[i-1], f[n-2] + cost[i-2])
        f0 = 0
        f1 = 0
        n = len(cost)

        for i in range(2, n+1):
            temp = min(f1 + cost[i-1], f0 + cost[i-2])
            f0 = f1
            f1 = temp
        return f1    
