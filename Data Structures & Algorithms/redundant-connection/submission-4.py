class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = list(range(len(edges) + 1))

        def find(x):
            while par[x] != x:
                par[x] = par[par[x]]  
                x = par[x]             
            return x            

        for u, v in edges:
            ru = find(u)
            rv = find(v)
            if ru == rv:
                return [u, v]
            par[ru] = rv             
