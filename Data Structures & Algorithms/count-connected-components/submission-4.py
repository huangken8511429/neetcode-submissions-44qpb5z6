class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        g = [[] for _ in range(n)]
        for e1, e2 in edges:
            g[e1].append(e2)
            g[e2].append(e1)

        visit = [False] * n

        def dfs(i) -> int:
            visit[i] = True
            for v in g[i]:
                if not visit[v]:
                    dfs(v)
        
        ans = 0

        for i, b in enumerate(visit):
            if not b: 
                dfs(i)
                ans += 1
        return ans            

