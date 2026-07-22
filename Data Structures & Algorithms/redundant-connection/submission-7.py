class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = list(range(len(edges) + 1))

        def find(x):
            while x != par[x]:
                 par[x] = par[par[x]]
                 x = par[x]
            return x

        for u, v in edges:
            nu = find(u)
            nv = find(v)
            if nu == nv:
                return [u,v]
            par[nu] = nv        
        return []                   

            
