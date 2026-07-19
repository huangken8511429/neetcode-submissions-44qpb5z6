DIRECTIONS = [(1, 0), (-1, 0), (0, -1), (0, 1)]
INF = 2147483647

class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        m = len(grid)
        n = len(grid[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    q.append((i, j))

        while q:
            row, col = q.popleft()
            for dr, dc in DIRECTIONS:
                nr = row + dr
                nc = col + dc
                if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == INF:
                    grid[nr][nc] = grid[row][col] + 1
                    q.append((nr, nc))
                    
                       