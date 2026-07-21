class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            g[b].append(a)
        colors = [0] * numCourses

        def dfs(i) -> bool:
            colors[i] = 1
            for adj in g[i]:
                if colors[adj] == 1 or colors[adj] == 0 and dfs(adj):
                    return True
            colors[i] = 2
            return False

        for c1, c2 in enumerate(colors):
            if c2 == 0 and dfs(c1):
                return False
        return True                         
            