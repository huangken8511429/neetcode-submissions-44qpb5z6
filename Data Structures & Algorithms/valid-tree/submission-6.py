class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False

        g = [[] for _ in range(n)]
        for a, b in edges:
            g[a].append(b)
            g[b].append(a)
        colors = [0] * n

        def dfs(i, parent) -> bool:
            colors[i] = 1
            for adj in g[i]:
                if adj == parent:
                    continue
                if colors[adj] == 1 or colors[adj] == 0 and dfs(adj, i):
                    return True
            colors[i] = 2        
            return False

        for c1, c2 in enumerate(colors):
            if c2 == 0 and dfs(c1, c2):
                return False
        return True            
