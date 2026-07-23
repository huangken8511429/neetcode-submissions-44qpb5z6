class Solution:
    def climbStairs(self, n: int) -> int:
        f0 = 1
        f1 = 1
        for i in range(n):
            temp = f0 + f1
            f0 = f1
            f1 = temp
        return f0