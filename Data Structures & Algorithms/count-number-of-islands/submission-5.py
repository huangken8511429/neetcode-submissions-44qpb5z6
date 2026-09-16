class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [(0, 1), (0, -1), (-1, 0), (1, 0)]
        m = len(grid)
        n = len(grid[0])

        def dfs(grid, row, col):
            if 0 <= row < m and 0 <= col < n and grid[row][col] != '0':   
                grid[row][col] = '0'
                for dr, dc in dirs:
                    new_row, new_col = row + dr, col + dc
                    dfs(grid, new_row, new_col)    

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(grid, i, j)
                    count += 1
        return count            
    