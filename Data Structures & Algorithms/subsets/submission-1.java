class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, subset, result);
        return result;
    }
    private void dfs(int index, 
                     int[] nums, 
                     List<Integer> subset, 
                     List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index+1, nums, subset, result);
        subset.remove(subset.size() - 1);
        dfs(index+1, nums, subset, result);
    }
}
