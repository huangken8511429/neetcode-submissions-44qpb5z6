from functools import cache
class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        n1 = len(s1)
        n2 = len(s2)

        if n1 + n2 != len(s3):
            return False

        f = [[False] * (n2+1) for _ in range(n1+1)]
        f[0][0] = True

        for i in range(n1+1):
            for j in range(n2+1):
                k = i + j - 1
                if i >= 1 and s1[i-1] == s3[k] and f[i-1][j]:
                    f[i][j] = True
                if j >= 1 and s2[j-1] == s3[k] and f[i][j-1]:
                    f[i][j] = True
        return f[n1][n2]  

        # @cache    
        # def dfs(i, j):
        #     if i < 0 and j < 0:
        #         return True
        #     k = i + j + 1    
        #     if i >= 0 and s1[i] == s3[k] and dfs(i-1, j):
        #         return True
        #     if j >= 0 and s2[j] == s3[k] and dfs(i, j-1):
        #         return True
        #     return False

        return dfs(n1-1, n2-1)                    