DIRECTIONS = ((1,0), (-1,0), (0, 1), (0, -1))
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        fresh = 0
        time = 0
        q = deque()

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i, j))
                if grid[i][j] == 1:
                    fresh += 1    

        while fresh > 0 and q:
            length = len(q)
            for _ in range(length):
                row, col = q.popleft()
                for dr, dc in DIRECTIONS:
                    nr = row + dr
                    nc = col + dc
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append((nr, nc))
                        fresh -= 1
            time += 1
        return time if fresh == 0 else -1                

                        


