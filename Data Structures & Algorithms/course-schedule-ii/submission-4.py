class Solution:
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(n)]
        for u, v in prerequisites:
            g[v].append(u)

        colors = [0] * n
        result = []

        def dfs(i) -> bool:
            if colors[i] == 1:
                return True
            colors[i] = 1    
            for adj in g[i]:
                if colors[adj] == 0: dfs(adj)
                elif colors[adj] == 1: return True
            colors[i] = 2
            result.append(i)

        for i in range(n):
            if dfs(i):
                return []
        return result[::-1]            


