class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
          # gas=[5,8,2,8]
          # cost=[6,5,6,6]
        if sum(gas) < sum(cost):
            return -1

        total = 0
        res = 0

        for i in range(len(gas)):
            total += gas[i] - cost[i]
            if total < 0:
                total = 0
                res = i + 1
        return res            

