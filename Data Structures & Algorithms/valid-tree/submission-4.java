class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int [] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] visit = new int[n];
        
        if (!dfs(0, -1, visit, g)) {
            return false;
        }
        for (int v : visit) {
          if (v != 2) return false;
        }
        return true;
    }

    private boolean dfs(int i, int parent, int[] visit, List<Integer>[] g) {
        visit[i] = 1;
    
        for (int j : g[i]) {
            if (j == parent) {
                continue;
            }
            if (visit[j] == 1 || visit[j] == 0 && !dfs(j, i, visit, g)) {
                return false;
            }
        }
        visit[i] = 2;
        return true;
    }
}
