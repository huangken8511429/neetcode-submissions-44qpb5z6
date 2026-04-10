class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] ans = new int[numCourses];
       int[] idx = {numCourses - 1};

        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        
        int[] color = new int[numCourses];

        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0 && dfs(i, ans, idx, color, g)) {
                return new int[0];
            }
        }
        return ans;
    }

    private boolean dfs(int i, int[] ans, int[] idx, int[] color, List<Integer>[] g) {
        color[i] = 1;
        
        for (int j : g[i]) {
            if (color[j] == 1 || color[j] == 0 && dfs(j, ans, idx, color, g)) {
                return true;
            } 
        }
        color[i] = 2;
        ans[idx[0]--] = i;
        return false;
    }
}
