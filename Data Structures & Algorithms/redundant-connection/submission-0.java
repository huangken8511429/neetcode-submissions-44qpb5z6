class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());


        for (int[] e : edges) {
            g[e[1]].add(e[0]);
            g[e[0]].add(e[1]);

            boolean[] visit = new boolean[n];
            if (dfs(e[0], -1, visit, g)) {
                return e;
            }
        }

       return new int[0];
    }

    private boolean dfs(int i, int parent, boolean[] visit, List<Integer>[] g) {
        if (visit[i]) {
            return true;
        }

        visit[i] = true;
        
        for (int j : g[i]) {
            if (j == parent) {
                continue;
            }
            if (dfs(j, i, visit, g)) {
                return true;
            }
        }
        return false;
    }
}
