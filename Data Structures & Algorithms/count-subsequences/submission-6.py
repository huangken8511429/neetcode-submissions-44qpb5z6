from functools import cache
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m = len(s)
        n = len(t)
        f = [0] * (n+1)
        f[0] = 1
        for c in s:
            for j in range(n-1, -1, -1):
                if c == t[j]:
                    f[j+1] += f[j]
        return f[n]             
        # for i in range(m):
        #     f[i][0] = 1

        # for i in range(m):
        #     for j in range(n):
        #         f[i+1][j+1] = f[i][j+1]
        #         if s[i] == t[j]:
        #             f[i+1][j+1] += f[i][j]
        # return f[m][n]                  

        # f[i+1][j+1] = f[i, j+1] + f[i][j]

        # @cache
        # def dfs(i, j):
        #     if j < 0:          
        #         return 1
        #     if i < 0:        
        #         return 0
        #     res = dfs(i - 1, j)         
        #     if s[i] == t[j]:
        #         res += dfs(i - 1, j - 1)   
        #     return res

        # return dfs(len(s) - 1, len(t) - 1)        