from functools import cache
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s)
        n = len(p)

        @cache
        def dfs(i, j):
            if j == n:
                return i == m

            is_match = i < m and j < n and (p[j] == '.' or p[j] == s[i])

            if j+1 < n and p[j+1] == '*':
                return dfs(i, j+2) or (is_match and dfs(i+1, j))
            
            return is_match and dfs(i+1, j+1)

        return dfs(0, 0)    