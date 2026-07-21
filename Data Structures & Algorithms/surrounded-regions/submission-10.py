directions = [(1,0), (-1,0), (0, 1), (0, -1)]
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        m = len(board)
        n = len(board[0])
        q = deque()

        for i in range(m):
            for j in range(n):
                if (i == 0 or i == m - 1 or j == 0 or j == n - 1 ) and board[i][j] == 'O':
                    q.append((i,j))

        while q:
            r, c = q.popleft()
            board[r][c] = 'T'
            for dr, dc in directions:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == 'O':
                    q.append((nr,nc))

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'T':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'

            
            
                
            
            