DIRECTIONS = [(1,0), (-1,0), (0, -1), (0, 1)]
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        
        area = 0

        def dfs(r, c):
            if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] == 0:
                return 0
            grid[r][c] = 0
            ans = 1
            for dr, dc in DIRECTIONS:
                ans += dfs(r + dr, c + dc)
            return ans

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, dfs(i, j))
        return area                        