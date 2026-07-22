class Solution:
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(n)]
        for x, y in prerequisites:
            g[y].append(x)
        
        colors = [0] * n
        ans = []
        def dfs(x) -> bool:
            colors[x] = 1
            for y in g[x]:
                if colors[y] == 1 or colors[y] == 0 and dfs(y):
                    return True
            colors[x] = 2
            ans.append(x)
            return False
        
        for i, c in enumerate(colors):
            if c == 0 and dfs(i):
                return []
        return ans[::-1]