class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        adj = defaultdict(list)
        indegree = [0] * numCourses
        
        for u, v in prerequisites:
            adj[v].append(u)
            indegree[u] += 1

        queue = deque([i for i in range(numCourses) if indegree[i] == 0])

        result = []

        while queue:
            neighbor = queue.popleft()
            result.append(neighbor)

            for v in adj[neighbor]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    queue.append(v)

        return len(result) == numCourses            
                