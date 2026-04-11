class Solution {
    int ans = 0;

    public int countComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] visit = new boolean[n];
        

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, visit, g); 
                ans++;        
            }
        }
        return ans;    
    }

    private void dfs(int i, boolean[] visit, List<Integer>[] g) {
        visit[i] = true;
        
        for (int j : g[i]) {
            if (!visit[j]) {
                dfs(j, visit, g);
            }
        }
    }
}
