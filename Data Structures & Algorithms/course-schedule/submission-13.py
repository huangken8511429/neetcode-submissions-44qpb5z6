class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]

        for target, pre in prerequisites:
            adj[pre].append(target)

        colors = [0] * numCourses

        def dfs(i):
            if colors[i] == 1:
                return False
            if colors[i] == 2:
                return True    
            colors[i] = 1

            for neighbor in adj[i]:
                if not dfs(neighbor):
                    return False

            colors[i] = 2

            return True

        for target, pre in prerequisites:
            if not dfs(pre):
                return False
        return True        




                          
