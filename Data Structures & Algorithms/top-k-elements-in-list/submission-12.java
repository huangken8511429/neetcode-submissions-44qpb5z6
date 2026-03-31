class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToCount = new HashMap<>();
        for (int num : nums) {
            numberToCount.put(num, numberToCount.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0 ; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : numberToCount.entrySet()) {
            Integer number = entry.getKey();
            Integer count = entry.getValue();
            freq[count].add(number);
        }
        int index = 0;
        int[] result = new int[k];
        for (int i = freq.length - 1 ; i > 0 && index < k; i--) {
           if (!freq[i].isEmpty()) {
            for (Integer frequence : freq[i]) {
                result[index++] = frequence;
                if (index == k) {
                    break;
                }
            }
           }
        }
        return result;
    };
}
