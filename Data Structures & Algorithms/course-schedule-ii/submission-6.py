class Solution:
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        adj = [[] for _ in range(n)]
        for u, v in prerequisites:
            adj[v].append(u)

        colors = [0] * n
        result = []

        def dfs(i) -> bool:
            if colors[i] == 1:
                return True
            colors[i] = 1    
            for v in adj[i]:
                if colors[v] == 0: dfs(v)
                elif colors[v] == 1: return True
            colors[i] = 2
            result.append(i)

        for i in range(n):
            if dfs(i):
                return []
        return result[::-1]            


