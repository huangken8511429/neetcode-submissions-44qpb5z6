from functools import cache
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        f = [False] * (n+1)
        f[n] = True
        for i in range(m, -1, -1):
            pre = f[n]
            f[n] = i == m
            for j in range(n-1, -1, -1):
                if p[j] == '*':
                    continue
                tmp = f[j]    
                is_match = i < m and (s[i] == p[j] or p[j] == '.')    
                if j + 1 < n and p[j+1] == '*':
                    f[j] = f[j+2] or is_match and f[j]
                else:
                    f[j] = is_match and pre
                pre = tmp    

        return f[0]

        # n, m = len(s), len(p)
        # f = [[False] * (m + 1) for _ in range(n + 1)]
        # f[n][m] = True

        # for i in range(n, -1, -1):
        #     for j in range(m - 1, -1, -1):
        #         if p[j] == '*':
        #             continue
        #         is_match = i < n and (p[j] == '.' or p[j] == s[i])
        #         if j + 1 < m and p[j + 1] == '*':
        #             f[i][j] = f[i][j + 2] or is_match and f[i + 1][j]
        #         else:
        #             f[i][j] = is_match and f[i + 1][j + 1]

        # return f[0][0]
          
        # m = len(s)
        # n = len(p)

        # @cache
        # def dfs(i, j):
        #     if j == n:
        #         return i == m

        #     is_match = i < m and j < n and (p[j] == '.' or p[j] == s[i])

        #     if j+1 < n and p[j+1] == '*':
        #         return dfs(i, j+2) or (is_match and dfs(i+1, j))
            
        #     return is_match and dfs(i+1, j+1)

        # return dfs(0, 0)    