class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        dirs = [(0,1), (0,-1), (1,0), (-1, 0)]
        m = len(grid)
        n = len(grid[0])

        def dfs(r, c):
            if 0 <= r < m and 0 <= c < n and grid[r][c] == 1:
                grid[r][c] = 0
                area = 1
                for dr, dc in dirs:
                    area += dfs(r+dr, c+dc)
                return area
            else:
                return 0

        area = 0        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, dfs(i,j))
        return area                           
                