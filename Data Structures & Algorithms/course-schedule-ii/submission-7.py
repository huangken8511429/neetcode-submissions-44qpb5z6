class Solution:
    def findOrder(self, n: int, prerequisites: List[List[int]]) -> List[int]:
        adj = defaultdict(list)
        indegree = [0] * n
        
        for dst, src in prerequisites:
            adj[src].append(dst)
            indegree[dst] += 1

        queue = deque([i for i in range(n) if indegree[i] == 0])

        result = []

        while queue:
            node = queue.popleft()
            result.append(node)

            for neighbor in adj[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)

        return result if len(result) == n else []            

        

