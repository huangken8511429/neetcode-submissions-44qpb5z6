class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        #  樹的邊只會有n-1，找出多出來的那條邊
        n = len(edges)
        size = n + 1
        g = [[] for _ in range(size)]

        def dfs(i, parent):
            if visit[i]:
                return True
            visit[i] = True
            for adj in g[i]:
                if adj == parent:
                    continue
                if dfs(adj, i):
                    return True
            return False

        for n , v in edges:
            g[n].append(v)
            g[v].append(n)
            visit = [False] * size
            if dfs(n, -1):
                return [n, v]
        return []            

            
