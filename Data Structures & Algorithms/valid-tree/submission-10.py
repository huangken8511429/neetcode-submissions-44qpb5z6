class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        g = [[] for _ in range(n)]
        for e1, e2 in edges:
            g[e1].append(e2)
            g[e2].append(e1)

        visit = [False] * n
        def dfs(i, parent) -> bool:
            if visit[i]:
                return True
            visit[i] = True
            for adj in g[i]:
                if adj == parent:
                    continue
                if dfs(adj, i):
                    return True
            return False

        if dfs(0, -1):
            return False
            
        return all(visit)      
                                

