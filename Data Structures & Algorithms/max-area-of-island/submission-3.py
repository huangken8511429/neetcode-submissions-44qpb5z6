DIRECTIONS = [(-1, 0), (1, 0), (0, 1), (0, -1)]
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        def bfs(r, c):
            q = deque()
            grid[r][c] = 0
            q.append((r, c))
            res = 1

            while q:
                row, col = q.popleft()
                for dr, dc in DIRECTIONS:
                    nr, nc = row + dr, col + dc
                    if nr < 0 or nr >= m or nc < 0 or nc >= n or grid[nr][nc] == 0:
                        continue
                    res += 1
                    q.append((nr, nc))
                    grid[nr][nc] = 0
            return res

        area = 0    
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    area = max(area, bfs(i, j))
        return area            

            

                
