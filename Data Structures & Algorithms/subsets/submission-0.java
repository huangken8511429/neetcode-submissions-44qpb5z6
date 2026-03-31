class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int num : nums) {
            int size = results.size();
            for (int i = 0 ; i < size ; i++) {
              List<Integer> subset = new ArrayList<>(results.get(i));
              subset.add(num);
              results.add(subset);
            }
        }
        return results;
    }
}
