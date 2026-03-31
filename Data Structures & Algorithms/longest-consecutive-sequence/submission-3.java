class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        
        for (int num : nums) {
            numberSet.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!numberSet.contains(num - 1)) {
                int length = 1;
                while (numberSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
               
    }
}
