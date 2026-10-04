class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses

        for target, pre in prerequisites:
            adj[pre].append(target)
            indegree[target] += 1

        queue = deque([i for i in range(numCourses) if indegree[i] == 0])
        result = []
        while queue:
            vertex = queue.popleft()
            result.append(vertex)
            for neighbor in adj[vertex]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)
        
        return len(result) == numCourses






                          
