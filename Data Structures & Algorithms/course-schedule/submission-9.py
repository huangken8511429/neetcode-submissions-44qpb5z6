class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        for p0, p1 in prerequisites:
            g[p1].append(p0)
        colors = [0] * numCourses

        def dfs(i) -> bool:
            colors[i] = 1
            for nei in g[i]:
                if colors[nei] == 1:
                    return True
                if colors[nei] == 0 and dfs(nei):
                    return True
            colors[i] = 2        
            return False

        for c1, c2 in enumerate(colors):
            if c2 == 0 and dfs(c1):
                return False
        return True        
                          
