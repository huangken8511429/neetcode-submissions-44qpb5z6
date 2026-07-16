DIRECTIONS = [(-1, 0), (1, 0), (0, 1), (0, -1)]
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        visit = set()

        def dfs(r, c):
            if r < 0 or r >= m or c < 0 or c >= n or grid[r][c] == 0 or (r, c) in visit:
                return 0
            visit.add((r,c))
            ans = 1
            for dr, dc in DIRECTIONS:
                ans += dfs(r + dr, c+dc)
            return ans

        area = 0
        for r in range(m):
            for c in range(n):
                area = max(area, dfs(r, c))
        return area                
                
