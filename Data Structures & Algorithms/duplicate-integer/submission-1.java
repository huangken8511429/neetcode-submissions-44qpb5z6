class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0 ; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        return sets.size() != nums.length;
    }
}