class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>()); // 標記每個課程的"臨邊"
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]); //建立有向環圖
        }
        int[] colors = new int[numCourses]; // 總共三個狀態 0代表沒被訪問過 1訪問過 2 dfs已經訪問完了且沒有還
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i , List<Integer>[] g, int[] colors) {
      colors[i] = 1;
      for (int j : g[i]) {
        if (colors[j] == 1 || colors[j] == 0 && dfs(j, g, colors)) {
            return true;
        }
      }
      colors[i] = 2;
      return false;
    }
}
