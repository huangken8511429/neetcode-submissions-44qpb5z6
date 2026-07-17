DIRECTIONS = [(1,0), (-1,0), (0,1), (0,-1)]
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        q = deque()
        fresh = 0
        
        ans = 0 
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i, j))    


        while fresh > 0 and q:
            length = len(q)
            for i in range(length):
                row, col = q.popleft() 
                for dr, dc in DIRECTIONS:
                    nr = row + dr
                    nc = col + dc
                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        q.append((nr, nc))
                        fresh -= 1
            ans += 1        
                        
        return ans if fresh == 0 else -1          

        