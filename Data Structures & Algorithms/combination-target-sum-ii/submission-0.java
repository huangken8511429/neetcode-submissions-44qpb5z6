class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, candidates, 0, target);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] candidates, int i, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = i ; j < candidates.length && candidates[j] <= target; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            path.add(candidates[j]);
            dfs(ans, path, candidates, j + 1, target - candidates[j]);
            path.removeLast();
         }
    }
}

