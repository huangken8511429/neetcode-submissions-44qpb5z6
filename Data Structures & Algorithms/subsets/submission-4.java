class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> path = new ArrayList<>();
     dfs(ans, path, nums, 0);
     return ans;   
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 不選
        dfs(ans, path, nums, i + 1);

        path.add(nums[i]);
        dfs(ans, path, nums, i + 1);
        path.removeLast();
    }
}
