DIRECTIONS = [(1,0), (0, -1), (-1,0), (0, 1)]
class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m = len(heights)
        n = len(heights[0])
        pac = [[False] * n for _ in range(m)]
        atl = [[False] * n for _ in range(m)]

        def bfs(source, ocean):
            q = deque(source)
            while q:
                row, col = q.popleft()
                ocean[row][col] = True
                for dr, dc in DIRECTIONS:
                    nr = row + dr
                    nc = col + dc
                    if 0 <= nr < m and 0 <= nc < n and not ocean[nr][nc] and heights[nr][nc] >= heights[row][col]:
                        q.append((nr, nc))


        pacific = []
        atlantic = []

        for c in range(n):
            pacific.append((0,c))
            atlantic.append((m-1, c))

        for r in range(m):
            pacific.append((r, 0))
            atlantic.append((r, n-1))

        bfs(pacific, pac)
        bfs(atlantic, atl)

        ans = []
        for r in range(m):
            for c in range(n):
                if pac[r][c] and atl[r][c]:
                    ans.append((r, c))
        return ans            


        
            