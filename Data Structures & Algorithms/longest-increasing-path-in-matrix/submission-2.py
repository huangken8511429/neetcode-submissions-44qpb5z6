from functools import cache
DIRECTIONS = [(1, 0), (-1, 0), (0, -1), (0, 1)]
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        
        @cache
        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n:
                return 0
            ans = 1
            for dr, dc in DIRECTIONS:
                nr = i + dr
                nc = j + dc
                if 0 <= nr < m and 0 <= nc < n and matrix[i][j] < matrix[nr][nc]:
                    ans = max(ans, 1 + dfs(nr, nc))
            return ans

        ans = 0    
        for i in range(m):
            for j in range(n):
                    ans = max(ans, dfs(i, j))
        return ans            
