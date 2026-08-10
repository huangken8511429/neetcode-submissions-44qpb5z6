from functools import cache
class Solution:
    def minDistance(self, s: str, t: str) -> int:
        m = len(s)
        n = len(t)
        #  monkeys, money
        #  m = 7, n = 5

        #  0 1 2 3 4 5
        #  1 0 0 0 0 0
        #  2 0 0 0 0 0 
        #  3 0 0 0 0 0 
        #  4 0 0 0 0 0
        #  5 0 0 0 0 0
        #  6 0 0 0 0 0
        #  7 0 0 0 0 0
        f = [[0] * (n+1) for _ in range(m+1)]
        f[0] = list(range(n+1))
        
        for i, x in enumerate(s):
            f[i+1][0] = i + 1
            for j, y in enumerate(t):
                if x == y:
                    f[i+1][j+1] = f[i][j]
                else:
                    f[i+1][j+1] = min(f[i][j+1], f[i+1][j], f[i][j]) + 1
        return f[m][n]            
                
        # @cache
        # def dfs(i, j):
        #     if i < 0:
        #         return j + 1
        #     if j < 0:
        #         return i + 1
        #     if s[i] == t[j]:
        #         return dfs(i-1, j-1)
        #     return min(dfs(i-1, j), dfs(i, j-1), dfs(i-1, j-1)) + 1

        # return dfs(m-1, n-1)               