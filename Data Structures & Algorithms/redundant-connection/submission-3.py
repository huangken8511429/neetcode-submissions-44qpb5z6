class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        size = n + 1
        g = [[] for _ in range(size)]

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

        for a, b in edges:
            g[a].append(b)
            g[b].append(a)
            visit = [False] * size
            if dfs(a, -1):
                return [a,b]
        return []            

