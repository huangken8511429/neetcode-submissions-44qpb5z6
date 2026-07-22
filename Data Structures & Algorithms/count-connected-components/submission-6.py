class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        g = [[] for _ in range(n)]
        for e1,e2 in edges:
            g[e1].append(e2)
            g[e2].append(e1)

        visit = [False] * n

        def dfs(i):
            if visit[i]:
                return
            visit[i] = True
            for adj in g[i]:
                if not visit[adj]:
                    dfs(adj)     

        ans = 0    
        for i in range(n):
            if not visit[i]:
                dfs(i)
                ans += 1
        return ans                        