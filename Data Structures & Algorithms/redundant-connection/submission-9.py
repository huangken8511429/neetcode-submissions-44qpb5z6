class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        par = list(range(len(edges) + 1))

        def find(i):
            while i != par[i]:
                i = par[i]
            return i

        for u, v in edges:
            nu = find(u)
            nv = find(v)
            if nu == nv:
                return [u, v]
            par[nu] = nv
        return []                      

            
