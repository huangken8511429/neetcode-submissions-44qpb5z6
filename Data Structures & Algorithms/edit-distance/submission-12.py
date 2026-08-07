from functools import cache
class Solution:
    def minDistance(self, s: str, t: str) -> int:
        n, m = len(s), len(t)
        f = [[0] * (m+1) for _ in range(n+1)]
        f[0] = list(range(m+1))

        for i, x in enumerate(s):
            f[i+1][0] = i + 1
            for j, c in enumerate(t):
                if c == x:
                    f[i+1][j+1] = f[i][j]
                else:
                    f[i+1][j+1] = min(f[i][j+1], f[i+1][j], f[i][j]) + 1
        return f[n][m]            

        # @cache  
        # def dfs(i: int, j: int) -> int:
        #     if i < 0:
        #         return j+1
        #     if j < 0:
        #         return i+1
        #     if s[i] == t[j]:
        #         return dfs(i-1, j-1)
        #     return min(dfs(i-1, j), dfs(i, j-1), dfs(i-1, j-1)) + 1            
        # return dfs(n - 1, m - 1)