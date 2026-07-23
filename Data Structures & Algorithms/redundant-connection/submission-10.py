class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = []
        for i in range(0, len(edges)+1):
            par.append(i)

        def find(x):
            while x != par[x]:
                par[x] = par[par[x]]
                x = par[x]
            return x

        for n, v in edges:
            n1 = find(n)
            v1 = find(v)
            if n1 == v1:
                return [n,v]
            par[n1] = v1
        return []            