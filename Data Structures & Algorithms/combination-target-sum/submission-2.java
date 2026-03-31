class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 0, nums, target);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int i, int[] nums, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || i >= nums.length) return;
      

        dfs(ans, path, i+1, nums, target);

        path.add(nums[i]);
        dfs(ans, path, i, nums, target - nums[i]);  
        path.removeLast();
    }
}
