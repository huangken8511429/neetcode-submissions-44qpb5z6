class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        n, m = len(s1), len(s2)
        if n + m != len(s3):
            return False

        f = [False] * (m + 1)
        f[0] = True
        for j, y in enumerate(s2):
            f[j + 1] = f[j] and y == s3[j]
        for i, x in enumerate(s1):
            f[0] = f[0] and x == s3[i]
            for j, y in enumerate(s2):
                f[j + 1] = f[j + 1] and x == s3[i + j + 1] or \
                           f[j] and y == s3[i + j + 1]
        return f[m]


    #    f[i][j] = f[i-1][j] or f[i][j-1]
    #    f[i+1][j+1] = f[i][j+1] or f[i+1][j]


        # @cache  
        # def dfs(i: int, j: int) -> bool:
        #     if i < 0 and j < 0:
        #         return True
        #     return i >= 0 and s1[i] == s3[i + j + 1] and dfs(i - 1, j) or \
        #            j >= 0 and s2[j] == s3[i + j + 1] and dfs(i, j - 1)

        # return dfs(n - 1, m - 1)
