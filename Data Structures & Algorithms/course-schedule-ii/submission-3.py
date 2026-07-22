class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(numCourses)]
        for p0, p1 in prerequisites:
            g[p1].append(p0)

        colors = [0] * numCourses
        ans = []
        def dfs(i):
            colors[i] = 1
            for adj in g[i]:
                if colors[adj] == 1 or colors[adj] == 0 and dfs(adj):
                    return True
            colors[i] = 2
            ans.append(i)
            return False

       
        for c0, c1 in enumerate(colors):
            if c1 == 0 and dfs(c0):
                return []
        return ans[::-1]        
