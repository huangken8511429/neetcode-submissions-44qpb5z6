class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        dfs(ans, path, 0, nums, pick);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int i, int[] nums, boolean[] pick) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (!pick[j]) {
             path.add(nums[j]);
             pick[j] = true;
             dfs(ans, path, j+1, nums, pick);
             path.removeLast();
             pick[j] = false;
            }
         }
    }
}
