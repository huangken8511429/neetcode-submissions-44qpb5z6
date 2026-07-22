class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        # 樹只會有 n -1 個節點，題目很明確的說會有n個節點，多出來的就是多出來的邊
        par = list(range(len(edges) + 1))

        def find(x):
            while par[x] != x:
                par[x] = par[par[x]]
                x = par[x]
            return x

        for u, v in edges:
            nu = find(u)
            nv = find(v)
            if nu == nv:
                return [u,v]
            par[nu] = nv    

