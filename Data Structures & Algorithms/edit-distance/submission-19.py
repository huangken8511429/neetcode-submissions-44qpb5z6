from functools import cache
class Solution:
    def minDistance(self, s: str, t: str) -> int:
        m = len(s)
        n = len(t)

        f = list(range(n+1))
        
        for i, x in enumerate(s):
            pre = f[0]
            f[0] = i+1 # f[i+1][j]
            for j, y in enumerate(t):
                tmp = f[j+1]
                if x == y:
                    f[j+1] = pre
                else:
                    f[j+1] = min(f[j+1], f[j], pre) + 1
                pre = tmp    
        return f[n]            
                
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