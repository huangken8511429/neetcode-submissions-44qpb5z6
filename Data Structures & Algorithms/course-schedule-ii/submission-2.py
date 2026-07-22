class Solution:
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(n)]
        for a, b in prerequisites:
            g[b].append(a)
        colors = [0] * n
        ans = []

        def dfs(i) -> bool:
            colors[i] = 1
            for a in g[i]:
                if colors[a] == 1 or colors[a] == 0 and dfs(a):
                    return True
            colors[i] = 2
            ans.append(i)
            return False

        for c1, c2 in enumerate(colors):
            if c2 == 0 and dfs(c1):
                return []
        return ans[::-1]                   
