class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> numberToCount = new HashMap<>();
      for (int num : nums) {
        numberToCount.put(num, numberToCount.getOrDefault(num, 0) + 1);
      }
      List<Integer>[] frequent = new List[nums.length + 1];
      for (int i = 0; i < frequent.length; i++) {
       frequent[i] = new ArrayList<>();   
      }
     for (Map.Entry<Integer,Integer> entry : numberToCount.entrySet()) {
        Integer number = entry.getKey();
        Integer count = entry.getValue();
        frequent[count].add(number);
      }
      int [] result = new int[k];
      int index = 0;
      for (int i = frequent.length - 1; i > 0 && index < k; i--) {
        if (!frequent[i].isEmpty()) {
            for (Integer num : frequent[i]) {
             result[index++] = num;
            if (index == k) {
                break;
            }
         }   
        }
      }
      return result;
    }
}
