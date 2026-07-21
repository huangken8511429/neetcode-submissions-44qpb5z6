class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        for a, b in prerequisites:
            g[b].append(a)
        colors = [0] * numCourses    
        def dfs(i:int) -> bool:
            colors[i] = 1
            for adj in g[i]:
                if colors[adj] == 1 or colors[adj] == 0 and dfs(adj):
                    return True
            colors[i] = 2    
            return False

        for i,j in enumerate(colors):
            if j == 0 and dfs(i):
                return False
        return True 
